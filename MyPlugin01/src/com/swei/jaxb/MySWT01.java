package com.swei.jaxb;

import javax.xml.bind.JAXBException;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;

import com.swei.jaxb.model.Factory;
import com.swei.jaxb.model.TreeContentProvider;
import com.swei.jaxb.model.TreeLabelProvider;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;

public class MySWT01 {

	protected Shell shell;
	private static Tree tree;
	private String path;
	
	public MySWT01(String path) {
		this.path = path;
	}
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MySWT01 window = new MySWT01("src/com/jaxb/test.xml");
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
//		while (!shell.isDisposed()) {
//			if (!display.readAndDispatch()) {
//				display.sleep();
//			}
//		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(500, 500);
		shell.setText("SWT Application");
		
		final TreeViewer treeViewer = new TreeViewer(shell, SWT.BORDER | SWT.H_SCROLL);
		tree = treeViewer.getTree();
		tree.setBounds(83, 75, 264, 185);
		treeViewer.setLabelProvider(new TreeLabelProvider());
		treeViewer.setContentProvider(new TreeContentProvider());
		treeViewer.setInput(Factory.createTree());
		
		shell.setLayout(new FillLayout());
		
		
		Button btnClose = new Button(shell, SWT.NONE);
		btnClose.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Display.getCurrent().dispose();
			}
		});
		btnClose.setBounds(10, 93, 80, 27);
		btnClose.setText("Close");
		
		Button btnShowOrgsCount = new Button(shell, SWT.NONE);
		btnShowOrgsCount.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageBox messageBox = new MessageBox(shell, SWT.ICON_INFORMATION | SWT.CANCEL | SWT.OK);
				try {
					messageBox.setMessage(JaxbReadXml.getTestOrgs(path).size() + "");
				} catch (JAXBException e1) {
					e1.printStackTrace();
				}
				messageBox.open();
				
//				Shell s1 = new Shell(shell);
//				s1.setSize(500, 375);
//				s1.setText("TreeViewer");
//				final TreeViewer treeViewer = new TreeViewer(s1, SWT.BORDER | SWT.H_SCROLL);
//				tree = treeViewer.getTree();
//				tree.setBounds(83, 75, 264, 185);
//				treeViewer.setLabelProvider(new TreeLabelProvider());
//				treeViewer.setContentProvider(new TreeContentProvider());
//				treeViewer.setInput(Factory.createTree());
//				
//				s1.open();
//				s1.setLayout(new FillLayout());
//				s1.layout();
//				while(!s1.isDisposed()){
//					if(!Display.getCurrent().readAndDispatch())
//							Display.getCurrent().sleep();
//				}
			}
		});
		btnShowOrgsCount.setBounds(10, 10, 132, 27);
		btnShowOrgsCount.setText("Show Orgs Count");

	}
}
