package com.example.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.xml.bind.JAXBException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.dnd.TemplateTransferDragSourceListener;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.parts.ContentOutlinePage;
import org.eclipse.gef.ui.parts.GraphicalEditorWithPalette;
import org.eclipse.gef.ui.parts.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

import com.example.dnd.DiagramTemplateTransferDropTargetListener;
import com.example.model.Diagram;
import com.example.parts.PartFactory;
import com.example.parts.TreePartFactory;
import com.example.tools.PaletteFactory;
import com.swei.jaxb.JaxbReadXml;
import com.swei.jaxb.MySWT01;
import com.swei.jaxb.TestOrg;
import com.swei.jaxb.TestOrgs;

/**
 * @author Swei
 *
 */
public class PracticeEditor extends GraphicalEditorWithPalette {

    private Diagram diagram = new Diagram();

    private PaletteRoot paletteRoot;

    public Diagram getDiagram() {
        return this.diagram;
    }

    public PracticeEditor() {
    	//System.out.println("PracticeEditor --------  PracticeEditor()!");
        setEditDomain(new DefaultEditDomain(this));
    }

    /**
     * 定制EditPartViewer
     * 与选择无关的初始化操作应该在这里完成
     */
    protected void configureGraphicalViewer() {
        super.configureGraphicalViewer();
       // System.out.println("PracticeEditor --------  configureGraphicalViewer()!");
        getGraphicalViewer().setRootEditPart(new ScalableFreeformRootEditPart());
        getGraphicalViewer().setEditPartFactory(new PartFactory());
    }
    /**
     * 初始化EditPartViewer
     * 与选择有关的初始化操作应该在这里完成
     */
    protected void initializeGraphicalViewer() {
    	//System.out.println("PracticeEditor --------  initializeGraphicalViewer()!");
        getGraphicalViewer().setContents(this.diagram);
        getGraphicalViewer().addDropTargetListener(new DiagramTemplateTransferDropTargetListener(getGraphicalViewer()));
    }

    public void doSave(IProgressMonitor monitor) {
    	//System.out.println("PracticeEditor --------  doSave()!");
    }

    public void doSaveAs() {
    	//System.out.println("PracticeEditor --------  doSaveAs()!");
    }

    public boolean isDirty() {
    	//System.out.println("PracticeEditor --------  isDirty()!");
        return getCommandStack().isDirty();
    }

    public boolean isSaveAsAllowed() {
    	//System.out.println("PracticeEditor --------  isSaveAsAllowed()!");
        return true;
    }

    protected void setInput(IEditorInput input) {
        super.setInput(input);
        /*********************************************************************************************************************************************************************************************************************/
        System.out.println("PracticeEditor --------  setInput()!");
        System.out.println(input.getName());
        System.out.println();
        IFileEditorInput iFileEditorInput = (IFileEditorInput) input; // 需要在MANIFEST.MF中加入org.eclipse.ui.ide的依赖
        IFile iFile = iFileEditorInput.getFile();
        
//        System.out.println("getFullPath  :  " + iFile.getFullPath());						// getFullPath  :  /Test01/src/test.gefpractice
//        System.out.println("getFileExtension  :  " + iFile.getFileExtension());				// getFileExtension  :  gefpractice
//        System.out.println("getPathVariableManager  :  " + iFile.getPathVariableManager());	// getPathVariableManager  :  org.eclipse.core.internal.resources.ProjectPathVariableManager@73ec417b
        System.out.println("getLocation  :  " + iFile.getLocation());						// getLocation  :  C:/Workspace/PluginDev/runtime-EclipseApplication/Test01/src/test.gefpractice
//        System.out.println("getLocationURI  :  " + iFile.getLocationURI());					// getLocationURI  :  file:/C:/Workspace/PluginDev/runtime-EclipseApplication/Test01/src/test.gefpractice
//        System.out.println("getProjectRelativePath  :  " + iFile.getProjectRelativePath());	// getProjectRelativePath  :  src/test.gefpractice 它是相对当前的project
        System.out.println("getRawLocation  :  " + iFile.getRawLocation());					// getRawLocation  :  C:/Workspace/PluginDev/runtime-EclipseApplication/Test01/src/test.gefpractice
//        System.out.println("getRawLocationURI  :  " + iFile.getRawLocationURI());			// getRawLocationURI  :  file:/C:/Workspace/PluginDev/runtime-EclipseApplication/Test01/src/test.gefpractice
//        System.out.println("getWorkspace  :  " + iFile.getWorkspace());						// getWorkspace  :  org.eclipse.core.internal.resources.Workspace@816272a
      
        InputStream is = null;
        BufferedReader br = null;
        String tmp = "";
        try {
			is = iFile.getContents(false);
			br = new BufferedReader(new InputStreamReader(is));
			while((tmp = br.readLine()) != null){
				System.out.println(tmp);
			}
		} catch (CoreException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        System.out.println("*********************************************************************************************************************************************************************************************************************");
        try {
        	TestOrgs testOrgs = JaxbReadXml.getTestOrgs(iFile.getLocation() + "");
        	System.out.println(testOrgs.getSize());
            System.out.println(testOrgs.getBatchNumber());
            System.out.println(testOrgs.getErrmsg());
            for (TestOrg o : testOrgs) {
                System.out.println(o.getOrgName());
            }
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

//        MySWT01 mySWT01 = new MySWT01(iFile.getLocation() + ""); //Show TreeViewer
//        mySWT01.open();
        
        System.out.println("*********************************************************************************************************************************************************************************************************************");
        /*********************************************************************************************************************************************************************************************************************/
       
        
        //        IFile file = ((IFileEditorInput) input).getFile();
        diagram = new Diagram();
        //        try { // attempt to read from a file
        //            InputStream istream = file.getContents(false);
        //            diagram = Diagram.makeFromStream(istream);
        //        } catch (Exception e) { // but if there's an error, create a new diagram
        //            e.printStackTrace();
        //            diagram = new Diagram();
        //        }
    }

    public Object getAdapter(Class type) {
    	//System.out.println("PracticeEditor --------  getAdapter()!");
        if (type == IContentOutlinePage.class)
            return new OutlinePage();
        return super.getAdapter(type);
    }

    protected PaletteRoot getPaletteRoot() {
    	//System.out.println("PracticeEditor --------  getPaletteRoot()!");
        if (this.paletteRoot == null) {
            this.paletteRoot = PaletteFactory.createPalette();
        }
        return this.paletteRoot;
    }

    protected void initializePaletteViewer() {
        super.initializePaletteViewer();
      //  System.out.println("PracticeEditor --------  initializePaletteViewer()!");
        getPaletteViewer().addDragSourceListener(new TemplateTransferDragSourceListener(getPaletteViewer()));
    }

    class OutlinePage extends ContentOutlinePage {
        //        private PageBook pageBook;

        private Control outline;

        public OutlinePage() {
            super(new TreeViewer());
        //    System.out.println("OutlinePage --------  OutlinePage()!");
        }

        public void init(IPageSite pageSite) {
            super.init(pageSite);
          //  System.out.println("OutlinePage --------  init()!");
            ActionRegistry registry = getActionRegistry();
            IActionBars bars = pageSite.getActionBars();
            
            String id = IWorkbenchActionConstants.UNDO;
            bars.setGlobalActionHandler(id, registry.getAction(id));
            
            id = IWorkbenchActionConstants.REDO;
            bars.setGlobalActionHandler(id, registry.getAction(id));
            
            id = IWorkbenchActionConstants.DELETE;
            bars.setGlobalActionHandler(id, registry.getAction(id));
            
            bars.updateActionBars();
        }

        public void createControl(Composite parent) {
            //            pageBook = new PageBook(parent, SWT.NONE);
            //            outline = getViewer().createControl(pageBook);
            //            pageBook.showPage(outline);
        	//System.out.println("OutlinePage --------  createControl()!");
            outline = getViewer().createControl(parent);
            getSelectionSynchronizer().addViewer(getViewer());
            getViewer().setEditDomain(getEditDomain());
            getViewer().setEditPartFactory(new TreePartFactory());
            //            getViewer().setKeyHandler(getCommonKeyHandler());
            getViewer().setContents(getDiagram());
        }

        public Control getControl() {
            //            return pageBook;
        	//System.out.println("OutlinePage --------  getControl()!");
            return outline;
        }

        public void dispose() {
        	//System.out.println("OutlinePage --------  dispose()!");
            getSelectionSynchronizer().removeViewer(getViewer());
            super.dispose();
        }
    }

}

