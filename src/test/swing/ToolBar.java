package test.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolBar extends JPanel implements ActionListener {

	private JButton helloButton;
	private JButton goodbyeButton;
	private StringListener stringListener;

	public ToolBar() {
		
		setBorder(BorderFactory.createEtchedBorder());
		
		helloButton = new JButton("Hello");
		goodbyeButton = new JButton("Goodbye");

		helloButton.addActionListener(this);
		goodbyeButton.addActionListener(this);

		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(helloButton);
		add(goodbyeButton);
	}

	public void setStringListener(StringListener listener) {
		stringListener = listener;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();

		if (clicked == helloButton) {
			if (stringListener != null)
				stringListener.textEmitted("Hello\n");

		} else if (clicked == goodbyeButton) {
			if (stringListener != null)
				stringListener.textEmitted("goodbye button clicked\n");
		}
	}

}
