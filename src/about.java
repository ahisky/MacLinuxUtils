/*
    Copyright 2021 Andrei Datcu.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
 */
package andreid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class about {
    // declaring variables
    JFrame about;
    JButton credits;
    JFrame attribution;
    JButton author;

    // setting variables
    public void setCredits(JButton credits) {
        this.credits = credits;
    }

    public void setAuthor(JButton author) {
        this.author = author;
    }

    public void setAbout(JFrame about) {
        this.about = about;
    }

    public void setAttribution(JFrame attribution) {
        this.attribution = attribution;
    }

    // methods responsible for functionality
    public JButton getAuthor() {
        author = new JButton("Author's Page");
        author.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Process p = Runtime.getRuntime().exec("xdg-open https://datcuandrei.github.io/");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        return author;
    }

    public JFrame getAttribution() {
        attribution = new JFrame("Attribution");
        attribution.setVisible(true);
        attribution.setSize(520,350);
        attribution.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        attribution.setLocationRelativeTo(null);
        attribution.setLayout(new FlowLayout(FlowLayout.CENTER));

        JTextPane text = new JTextPane();
        text.setContentType("text/html");
        text.setText("<html><head></head><body><div align=\"center\"><h1>Credits</h1><p>• MacLinuxUtils's UI would have not been possible without <b>FlatLaf</b> library.</p><p>• <b>Apache Commons IO</b> - library responsible for transfering files.</p><p>• Special thanks to the <b>Unsupported Macs</b> community.</p><br/><p><b>FlatLaf</b> : https://www.formdev.com/flatlaf/</p><p><b>Apache Commons IO</b> : https://commons.apache.org/proper/commons-io/</p><p><b>Unsupported Macs</b> : https://discord.gg/XbbWAsE</p></div></body></html>");
        text.setEditable(false);

        attribution.add(text);
        return attribution;
    }

    public JButton getCredits() {
        credits = new JButton("Credits");
        credits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getAttribution();
            }
        });
        return credits;
    }

    public JFrame getAbout() {
        about = new JFrame("About");
        about.setVisible(true);
        about.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        about.setLocationRelativeTo(null);
        about.setSize(520,330);
        about.setLayout(new FlowLayout(FlowLayout.CENTER));

        JTextPane text = new JTextPane();
        text.setContentType("text/html");
        text.setText("<html><head></head><body><div align=\"center\"><h1>MacLinuxUtils</h1><h2>2.3.5</h2><br><p> Bringing the functionality of macOS utilities to Linux Mac users.</p><br><p>Copyright © 2021 Andrei Datcu.<br>Licensed under the Apache License, Version 2.0<br>Powered by open-source software,see Credits for more information.</p></div></body></html>");
        text.setEditable(false);

        about.add(text);
        about.add(getCredits());
        about.add(getAuthor());
        return about;
    }
}
