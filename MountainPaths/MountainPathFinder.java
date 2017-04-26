
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class MountainPathFinder extends GraphicsProgram
{
	private TopologicalMap mountainMap;

	private JButton loadButton;
	private JButton drawButton;
	private JButton findPathButton;
	private JTextField fileNameField;
	private JTextField rowsField, colsField;

	public void init()
	{
		setSize(960, 560);
		setTitle("Mountain Path Finder");
		initGUI();
	}

	public void run()
	{
		addActionListeners();
	}

	private void initGUI()
	{
		// you'll do this in task #0
		JLabel filelabel = new JLabel("File name: ");
		add(filelabel,NORTH);
		fileNameField = new JTextField("Coloardo_480x480.txt");
		add(fileNameField, NORTH);
		JLabel sizeLabel = new JLabel("Map size:");
		add(sizeLabel, NORTH);
		rowsField = new JTextField("480");
		add(rowsField, NORTH);
		JLabel xLabel = new JLabel("X");
		add(xLabel, NORTH);
		colsField = new JTextField("480");
		add(colsField, NORTH);
		loadButton = new JButton("Load File");
		add(loadButton, NORTH);
		drawButton = new JButton("Draw Map");
		drawButton.setEnabled(false);
		add(drawButton, NORTH);
		findPathButton = new JButton("Find Path");
		findPathButton.setEnabled(false);
		add(findPathButton, NORTH);
	}

	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource() == loadButton)
			handleLoadButton();
		// more to do here eventually
	}

	private void handleLoadButton()
	{
		// you'll do this in task #2
		removeAll();
		mountainMap = new TopologicalMap(fileNameField.getText(), 
							Integer.parseInt(rowsField.getText()), 
							Integer.parseInt(colsField.getText()));
		if(mountainMap.isValid()){
			JOptionPane.showMessageDialog(null,"The map data loaded succesfully");
		}else{
			JOptionPane.showMessageDialog(null,"Something went wrong loading the map data");
		}
	}


}
