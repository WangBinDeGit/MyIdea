package com.kingbin.tools;


import com.kingbin.model.ResourceModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WangBin on 2018/11/23
 */
public class TreeUtils {

    /**
     * 两层循环实现建树
     *
     * @param treeNodes 传入的树节点列表
     * @param Pid       传入的树顶节点数据
     * @return
     */
    public static List<ResourceModel> bulid(List<ResourceModel> treeNodes, String Pid) {

        List<ResourceModel> trees = new ArrayList<ResourceModel>();

        for (ResourceModel treeNode : treeNodes) {

            if (Pid.equals(treeNode.getPID())) {
                trees.add(treeNode);
            }

            for (ResourceModel it : treeNodes) {
                if (it.getPID().equals(treeNode.getID())) {
                    if (treeNode.getChildren() == null) {
                        treeNode.setChildren(new ArrayList<ResourceModel>());
                    }
                    treeNode.getChildren().add(it);
                }
            }
        }
        return trees;
    }

    /**
     * 使用递归方法建树
     *
     * @param treeNodes 传入的树节点列表
     * @param Pid       传入的树顶节点数据
     * @return
     */
    public static List<ResourceModel> buildByRecursive(List<ResourceModel> treeNodes, String Pid) {
        List<ResourceModel> trees = new ArrayList<ResourceModel>();
        for (ResourceModel treeNode : treeNodes) {
            if (Pid.equals(treeNode.getPID())) {
                trees.add(findChildren(treeNode, treeNodes));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     *
     * @param treeNodes 传入的树节点列表
     * @return
     */
    private static ResourceModel findChildren(ResourceModel treeNode, List<ResourceModel> treeNodes) {
        treeNode.setChildren(new ArrayList<ResourceModel>());

        for (ResourceModel it : treeNodes) {
            if (treeNode.getID().equals(it.getPID())) {
                if (treeNode.getChildren() == null) {
                    treeNode.setChildren(new ArrayList<ResourceModel>());
                }
                treeNode.getChildren().add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }

}
