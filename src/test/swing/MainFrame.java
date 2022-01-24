package test.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class MainFrame extends JFrame {

	private TextPanel textArea;
	private ToolBar toolbar;
	private FormPanel formPanel;
	private String tabSpace = "\t";
	private String newLine = "\n";

	public MainFrame() {
		super("Hello World");

		setLayout(new BorderLayout());

		textArea = new TextPanel();
		toolbar = new ToolBar();
		formPanel = new FormPanel();

		// add menu
		setJMenuBar(createMenuBar());

		toolbar.setStringListener(new StringListener() {

			@Override
			public void textEmitted(String message) {
				textArea.appendText(message);
			}

		});

		formPanel.setFormListener(new FormListener() {
			public void formEventOccurred(FormEvents e) {
				String name = e.getName();
				String occupation = e.getOccupation();

				textArea.appendText(name + tabSpace + occupation + tabSpace + e.getAgeCat() + tabSpace + e.getEmpCat()
						+ tabSpace + e.getGender() + newLine);
			}
		});

		add(toolbar, BorderLayout.NORTH);

		add(textArea, BorderLayout.CENTER);
		add(formPanel, BorderLayout.WEST);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(700, 500);

		setVisible(true);

	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");

		JMenuItem exportData = new JMenuItem("Export Data..");
		JMenuItem importData = new JMenuItem("Import Data..");
		JMenuItem exit = new JMenuItem("Exit");

		fileMenu.add(exportData);
		fileMenu.add(importData);
		fileMenu.addSeparator();
		fileMenu.add(exit);

		JMenu windowMenu = new JMenu("window");

		JMenu showMenu = new JMenu("Show");

		JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Person Form");
		showFormItem.setSelected(true);

		// JCheckBoxItem
		// JRadioButtonItem

		showMenu.add(showFormItem);

		windowMenu.add(showMenu);

		// added menu to Menu bar
		menuBar.add(fileMenu);
		menuBar.add(windowMenu);

		showFormItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JCheckBoxMenuItem checkBox = (JCheckBoxMenuItem) e.getSource();
				formPanel.setVisible(checkBox.isSelected());

			}
		});

		// setup Mnemonics of menu Item
		fileMenu.setMnemonic(KeyEvent.VK_F);
		exit.setMnemonic(KeyEvent.VK_X);
		
		// SetUp Accelarator 
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));

		return menuBar;
	}

}
