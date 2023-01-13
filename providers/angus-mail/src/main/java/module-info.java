/*
 * Copyright (c) 2021, 2023 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

module org.eclipse.angus.mail {

    requires transitive java.logging;
    requires java.xml;                  // for text/xml handler
    requires java.desktop;              // for image/jpeg handler
    requires static java.security.sasl; // for OAuth2 support
    requires transitive jakarta.mail;
    requires transitive jakarta.activation;

    requires static org.graalvm.sdk; // for graal integration

    exports org.eclipse.angus.mail.util;
    exports org.eclipse.angus.mail.auth;
    exports org.eclipse.angus.mail.handlers;

    exports org.eclipse.angus.mail.iap;
    exports org.eclipse.angus.mail.imap;
    exports org.eclipse.angus.mail.imap.protocol;

    exports org.eclipse.angus.mail.pop3;

    exports org.eclipse.angus.mail.smtp;

    exports org.eclipse.angus.mail.util.logging;

    uses jakarta.mail.Provider;

    provides jakarta.mail.Provider with
            org.eclipse.angus.mail.imap.IMAPProvider,
            org.eclipse.angus.mail.imap.IMAPSSLProvider,
            org.eclipse.angus.mail.smtp.SMTPProvider,
            org.eclipse.angus.mail.smtp.SMTPSSLProvider,
            org.eclipse.angus.mail.pop3.POP3Provider,
            org.eclipse.angus.mail.pop3.POP3SSLProvider;
    provides jakarta.mail.util.StreamProvider with
            org.eclipse.angus.mail.util.MailStreamProvider;
}
