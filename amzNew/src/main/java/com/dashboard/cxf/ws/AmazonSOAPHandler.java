/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashboard.cxf.ws;

import java.util.Set;
import java.util.TreeSet;
import javax.xml.namespace.QName;

import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 *
 * @author jnieuwenhuis
 */
class AmazonSOAPHandler implements SOAPHandler<SOAPMessageContext> {

	public String action=null;
    public AmazonSOAPHandler(String action) {
    	this.action=action;
    }

    @Override
    public Set<QName> getHeaders() {
        return new TreeSet();
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        Boolean outboundProperty =
                (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (outboundProperty.booleanValue()) {
            try {
                AmazonSOAPHeaderData factory = new AmazonSOAPHeaderData(action);
                SOAPEnvelope envelope = context.getMessage().getSOAPPart().getEnvelope();
                SOAPHeader header = envelope.addHeader();
                factory.addInformationToSOAPHeader(header);
            } catch (Exception ex) {
                throw new RuntimeException("Exception occurred", ex);
            }
        } else {
            // inbound
        }
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void close(MessageContext context) {
        //
    }
}
