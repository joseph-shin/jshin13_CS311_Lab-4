import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import java.awt.Container;
import java.awt.BorderLayout;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

/**
 * Starting application code for CS 311 Lab 4.  Feel free to modify however you wish
 * or replace with your own custom GUI.
 * 
 * @author      Scot Morse
 */
public class Main implements Runnable, KeyListener, ListSelectionListener
{
    private static String windowTitle = "CS 311: Dictionary";
    private static int windowWidth = 400;
    private static int windowHeight = 800;
    private JFrame mainWindow;
	private JTextField searchField;
	private JList<String> resultList;
	private DefaultListModel<String> resultListModel;
    private JTextArea definitionArea;
    
    /**
     * Don't do any Swing GUI stuff here.  That needs to be executed from run which
     * is invoked in the correct event thread from main
     */
    public Main()
    {
        
    }
    
    /**
     * Setup GUI in the correct thread.  Required by the Runnable interface
     */
    public void run()
    {
        setupUI();
    }
    
    /**
     * Setup the user interface
     */
    private void setupUI() 
    {
        mainWindow = new JFrame( windowTitle );
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		// The user enters their search query here
        searchField = new JTextField();
        searchField.setBorder( BorderFactory.createTitledBorder( "Search" ) );
        searchField.addKeyListener( this );
        searchField.setFocusTraversalKeysEnabled(false);        // to capture VK_TAB or VK_ENTER key press
		// tab can mean complete this word while enter can mean a different kind of search
        
		// Search results are displayed in a JList 
		// (so we can let them click one and figure out which one was selected)
		resultListModel = new DefaultListModel<String>();
		resultListModel.addElement("No results yet");
		resultList = new JList<String>(resultListModel);
		resultList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		resultList.addListSelectionListener(this);
		resultList.setVisibleRowCount(10);
		JScrollPane scrollPane = new JScrollPane( resultList );
        scrollPane.setBorder( BorderFactory.createTitledBorder( "Results" ) );
		
		// text area to display the definition of a word
		definitionArea = new JTextArea();
		definitionArea.setLineWrap(true);
        JScrollPane scrollPane2 = new JScrollPane( definitionArea );
        scrollPane2.setBorder( BorderFactory.createTitledBorder( "Definition" ) );
        
		// layout
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.PAGE_AXIS));
		mainPanel.setBorder( BorderFactory.createEmptyBorder(10, 10, 10, 10) );
		mainPanel.add( scrollPane );
		mainPanel.add( scrollPane2);
 	   
	    Container cp = mainWindow.getContentPane();
	    cp.add( searchField, BorderLayout.NORTH );
        cp.add( mainPanel, BorderLayout.CENTER );
        
        mainWindow.setSize( windowWidth, windowHeight );
        mainWindow.setVisible(true);
    }
 
     /**
      * Application entry point.
      * 
      * @param args     This application takes no command line arguments
      */
    public static void main(String[] args) 
    {
        Main main = new Main();
        // Setup GUI on Swing's event thread
        SwingUtilities.invokeLater( main );
    }
    
	/**
	 *    Method required to fulfill the KeyListener contract.
	 *
	 * @param    e  The event object.
	 */
	public void keyTyped( KeyEvent e )
	{ 

	}

	/**
	 *    Method required to fulfill the KeyListener contract.
	 *
	 * @param    e  The event object.
	 */
	public void keyPressed( KeyEvent e )
	{
        System.out.println("Key pressed: " + e.getKeyChar());
		
		String currentString = searchField.getText();
        if( e.getKeyCode() == KeyEvent.VK_ENTER )
        {
			// example
			resultListModel.addElement("ENTER key pressed: " + currentString);
        }
        else if( e.getKeyCode() == KeyEvent.VK_TAB )
        {
			// example
			resultListModel.addElement("TAB key pressed: " + currentString);
        }
	}

	/**
	 *    Method required to fulfill the KeyListener interface
	 *
	 * @param    e  The event object.
	 */
	public void keyReleased( KeyEvent e )
	{

	}
	
	/**
	 * Method required to fulfill the ListSelectionListener interface
	 */
	public void valueChanged(ListSelectionEvent e)
	{
		if (e.getValueIsAdjusting() == false) 
		{
			if (resultList.getSelectedIndex() == -1) 
			{
		    	// no selection is made
		    } 
			else 
			{
				int rowSelected = resultList.getSelectedIndex();
				// do something to show it working
				System.out.printf("Row %s selected\n",rowSelected);
			}
		}			
	}
    
} // end class Main