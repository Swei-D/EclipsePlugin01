package com.example.commands;

import org.eclipse.gef.commands.Command;

import com.example.model.Diagram;
import com.example.model.Node;

/**
 * @author Swei
 *
 */
public class DeleteNodeCommand extends Command {
    private Diagram diagram;

    private Node node;
    
    private int index;

    public void setDiagram(Diagram diagram) {
        this.diagram = diagram;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    //------------------------------------------------------------------------
    // Overridden from Command

    public void execute() {
        index=diagram.getNodes().indexOf(node);
        diagram.removeNode(node);
    }

    public String getLabel() {
        return "Delete Node";
    }

    public void redo() {
        execute();
    }

    public void undo() {
        diagram.addNode(node);
    }
}