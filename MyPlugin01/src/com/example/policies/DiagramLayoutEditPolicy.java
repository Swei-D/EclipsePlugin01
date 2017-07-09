package com.example.policies;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import com.example.commands.CreateNodeCommand;
import com.example.commands.MoveNodeCommand;
import com.example.model.Diagram;
import com.example.model.Node;
import com.example.parts.NodePart;

/**
 * @author Swei
 *
 */
public class DiagramLayoutEditPolicy extends XYLayoutEditPolicy {

    protected Command createAddCommand(EditPart child, Object constraint) {
        return null;
    }

    protected Command createChangeConstraintCommand(EditPart child, Object constraint) {
        if (!(child instanceof NodePart))
            return null;
        if (!(constraint instanceof Rectangle))
            return null;

        MoveNodeCommand cmd = new MoveNodeCommand();
        cmd.setNode((Node) child.getModel());
        cmd.setLocation(((Rectangle) constraint).getLocation());
        return cmd;

    }

    protected Command getCreateCommand(CreateRequest request) {
        if (request.getNewObject() instanceof Node) {
            CreateNodeCommand cmd = new CreateNodeCommand();
            cmd.setDiagram((Diagram) getHost().getModel());
            cmd.setNode((Node) request.getNewObject());
            Rectangle constraint = (Rectangle) getConstraintFor(request);
            cmd.setLocation(constraint.getLocation());
            return cmd;
        }
        return null;
    }

    protected Command getDeleteDependantCommand(Request request) {
        return null;
    }
}