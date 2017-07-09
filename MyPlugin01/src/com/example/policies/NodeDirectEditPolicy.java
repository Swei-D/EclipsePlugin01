package com.example.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;

import com.example.commands.RenameNodeCommand;
import com.example.figures.NodeFigure;
import com.example.model.Node;


/**
 * @author Swei
 *
 */
public class NodeDirectEditPolicy extends DirectEditPolicy{

	/**
	 * �ڱ༭����ʱ����һ��Command���󣬽��޸Ľ�����õ�ģ��
	 */
    protected Command getDirectEditCommand(DirectEditRequest request) {
        RenameNodeCommand cmd = new RenameNodeCommand();
        cmd.setNode((Node) getHost().getModel());
        cmd.setName((String) request.getCellEditor().getValue());
        return cmd;
    }
    /**
     * ����Figure�е���ʾ
     */
    protected void showCurrentEditValue(DirectEditRequest request) {
        String value = (String) request.getCellEditor().getValue();
        ((NodeFigure) getHostFigure()).setName(value);
    }
}
