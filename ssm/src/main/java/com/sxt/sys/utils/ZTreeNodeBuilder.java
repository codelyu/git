package com.sxt.sys.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成前端要求的json对象
 * @author LJH
 *
 */
public class ZTreeNodeBuilder {
	
	/**
	 * 
	 * @param treeNodes从数据库里面查询出来的并封装到List<TreeNode>里面的对象
	 * @param topId
	 * @return
	 */
	public static List<ZtreeNode> build(List<ZtreeNode> treeNodes,Integer topId){
		List<ZtreeNode> nodes=new ArrayList<>();
		for (ZtreeNode treeNode : treeNodes) {
			if(treeNode.getPid()==topId){
				nodes.add(treeNode);
			}
			for (ZtreeNode node : treeNodes) {
				if(node.getPid()==treeNode.getId()){
					//如果父节点的isParent是False就把它变成true
					if(!node.getIsParent()) {
						treeNode.setIsParent(true);
					}
					treeNode.getChildren().add(node);
				}
			}
		}
		return nodes;
	}
}
