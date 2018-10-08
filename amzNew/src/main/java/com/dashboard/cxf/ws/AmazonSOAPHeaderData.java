/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashboard.cxf.ws;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPHeader;
import org.apache.commons.codec.binary.Base64;

public class AmazonSOAPHeaderData {

    private static final String UTF8_CHARSET = "UTF-8";
    private static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";
    private String awsAccessKeyId = "AKIAJ553PRTX3FNQEMIQ";
    private String awsSecretKey = "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";
    private String action = null;
    private static final String prefix = "aws";
    private static final String uri = "http://security.amazonaws.com/doc/2007-01-01/";
    private SecretKeySpec secretKeySpec = null;
    private Mac mac = null;

    public AmazonSOAPHeaderData(String action) {
        try {
            byte[] secretyKeyBytes = awsSecretKey.getBytes(UTF8_CHARSET);
            secretKeySpec = new SecretKeySpec(secretyKeyBytes, HMAC_SHA256_ALGORITHM);
            mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);
            mac.init(secretKeySpec);
            this.action=action;
        } catch (Exception e) {
            throw new RuntimeException(HMAC_SHA256_ALGORITHM + " is unsupported!", e);
        } 
    }

    private String hmac(String stringToSign) {
        String sig = "";
        byte[] data;
        byte[] rawHmac;
        try {
            data = stringToSign.getBytes(UTF8_CHARSET);
            rawHmac = mac.doFinal(data);
            Base64 encoder = new Base64();
            sig = new String(encoder.encode(rawHmac));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(UTF8_CHARSET + " is unsupported!", e);
        }
        return sig.trim();
    }

    private String createTimestamp() {
        Calendar cal = Calendar.getInstance();
        DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        dfm.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dfm.format(cal.getTime());
    }

    public void addInformationToSOAPHeader(SOAPHeader header) throws SOAPException {
        SOAPFactory factory = SOAPFactory.newInstance();
        String timestamp = createTimestamp();
        String signature = hmac(action + timestamp);

        SOAPElement accessKeyElem =
                factory.createElement("AWSAccessKeyId", prefix, uri);
        accessKeyElem.addTextNode(awsAccessKeyId);
        SOAPElement timestampElem =
                factory.createElement("Timestamp", prefix, uri);
        timestampElem.addTextNode(timestamp);
        SOAPElement signatureElem =
                factory.createElement("Signature", prefix, uri);
        signatureElem.addTextNode(signature);

        header.addChildElement(accessKeyElem);
        header.addChildElement(timestampElem);
        header.addChildElement(signatureElem);
    }
}
