package com.example.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import com.example.commands.DeleteNodeCommand;
import com.example.model.Diagram;
import com.example.model.Node;

/**
 * @author Swei
 *
 */
public class NodeEditPolicy extends ComponentEditPolicy{

    protected Command createDeleteCommand(GroupRequest deleteRequest) {
        DeleteNodeCommand deleteCommand=new DeleteNodeCommand();
        deleteCommand.setDiagram((Diagram)getHost().getParent().getModel());
        deleteCommand.setNode((Node)getHost().getModel());
        return deleteCommand;
    }
}
