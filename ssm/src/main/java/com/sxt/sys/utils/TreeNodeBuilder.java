package com.sxt.sys.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成前端要求的json对象
 * @author Administrator
 *
 */
public class TreeNodeBuilder {
	
	/**
	 * 
	 * @param treeNodes从数据库里面查询出来的并封装到List<TreeNode>里面的对象
	 * @param topId
	 * @return
	 */
	public static List<TreeNode> build(List<TreeNode> treeNodes,Integer topId){
		List<TreeNode> nodes=new ArrayList<>();
		for (TreeNode treeNode : treeNodes) {
			if(treeNode.getPid()==topId){
				nodes.add(treeNode);
			}
			for (TreeNode node : treeNodes) {
				if(node.getPid()==treeNode.getId()){
					treeNode.getChildren().add(node);
				}
			}
		}
		return nodes;
	}
	

}
