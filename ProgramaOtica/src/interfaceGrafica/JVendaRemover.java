package interfaceGrafica;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JVendaRemover extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JVendaRemover instance;
	
	public static JVendaRemover getInstance() {
		if (instance == null) {
			instance = new JVendaRemover();
			return instance;
		}
		else {
			return instance;
		}
	}

	public JVendaRemover() {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 720, 528);
		add(tabbedPane);
		
		JPanel panelVendaRemover = new JPanel();
		tabbedPane.addTab("Remover", null, panelVendaRemover, null);
		
		JLabel lblInserir = new JLabel("Remover");
		panelVendaRemover.add(lblInserir);
		
	}
}
