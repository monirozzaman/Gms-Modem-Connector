// SendMessage.java - Sample application.
//
// This application shows you the basic procedure for sending messages.
// You will find how to send synchronous and asynchronous messages.
//
// For asynchronous dispatch, the example application sets a callback
// notification, to see what's happened with messages.

package org.ajwcc.pduUtils.test.integration;

import org.smslib.OutboundMessage;
import org.smslib.Service;

public class SendPortedTextMessage extends AbstractTester {
    public static void main(String args[]) {
        SendPortedTextMessage app = new SendPortedTextMessage();
        try {
            app.initModem();
            app.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void test() throws Exception {
        OutboundMessage msg;
        // basic message
        msg = new OutboundMessage(MODEM_NUMBER, "Hello from SMSLib!");
        // port of j2me app
        msg.setSrcPort(0);
        msg.setDstPort(4501);
        Service.getInstance().sendMessage(msg);
        System.out.println(msg);
        System.out.println("Now Sleeping - Hit <enter> to terminate.");
        System.in.read();
        Service.getInstance().stopService();
    }
}
