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
	 * 在编辑结束时生成一个Command对象，将修改结果作用到模型
	 */
    protected Command getDirectEditCommand(DirectEditRequest request) {
        RenameNodeCommand cmd = new RenameNodeCommand();
        cmd.setNode((Node) getHost().getModel());
        cmd.setName((String) request.getCellEditor().getValue());
        return cmd;
    }
    /**
     * 更行Figure中的显示
     */
    protected void showCurrentEditValue(DirectEditRequest request) {
        String value = (String) request.getCellEditor().getValue();
        ((NodeFigure) getHostFigure()).setName(value);
    }
}
