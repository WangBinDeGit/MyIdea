package com.kingbin.tools;


import com.kingbin.model.ResourceModels;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WangBin on 2018/11/23
 */
public class TreeUtil {

    /**
     * 两层循环实现建树
     *
     * @param treeNodes 传入的树节点列表
     * @param Pid       传入的树顶节点数据
     * @return
     */
    public static List<ResourceModels> bulid(List<ResourceModels> treeNodes, String Pid) {

        List<ResourceModels> trees = new ArrayList<ResourceModels>();

        for (ResourceModels treeNode : treeNodes) {

            if (Pid.equals(treeNode.getPID())) {
                trees.add(treeNode);
            }

            for (ResourceModels it : treeNodes) {
                if (it.getPID().equals(treeNode.getID())) {
                    if (treeNode.getChildren() == null) {
                        treeNode.setChildren(new ArrayList<ResourceModels>());
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
    public static List<ResourceModels> buildByRecursive(List<ResourceModels> treeNodes, String Pid) {
        List<ResourceModels> trees = new ArrayList<ResourceModels>();
        for (ResourceModels treeNode : treeNodes) {
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
    private static ResourceModels findChildren(ResourceModels treeNode, List<ResourceModels> treeNodes) {
        treeNode.setChildren(new ArrayList<ResourceModels>());

        for (ResourceModels it : treeNodes) {
            if (treeNode.getID().equals(it.getPID())) {
                if (treeNode.getChildren() == null) {
                    treeNode.setChildren(new ArrayList<ResourceModels>());
                }
                treeNode.getChildren().add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }


    public static void main(String[] args) {
        List<ResourceModels> allNodes = new ArrayList<ResourceModels>();
        allNodes.add(new ResourceModels("1F0102827B214E4CA94BA05D7E2DD0D5", "-1", "系统管理", 1));
        allNodes.add(new ResourceModels("CC4D3DDC25E747DEB1ADBA9AA8AACEE5", "1F0102827B214E4CA94BA05D7E2DD0D5", "系统管理", 2));
        allNodes.add(new ResourceModels("2D5CCF46CD844A41AA092D309AAB4EDB", "CC4D3DDC25E747DEB1ADBA9AA8AACEE5", "组织结构维护", 3));
        allNodes.add(new ResourceModels("CB268EC3AA984BF4B0664C79741DB314", "CC4D3DDC25E747DEB1ADBA9AA8AACEE5", "用户信息维护", 3));
        allNodes.add(new ResourceModels("6FDCE02E57C04663B966D78ECAFF5491", "1F0102827B214E4CA94BA05D7E2DD0D5", "资源管理", 2));
        allNodes.add(new ResourceModels("217FDA9A9D9A48D28F228C955195402E", "6FDCE02E57C04663B966D78ECAFF5491", "资源信息维护", 3));
        allNodes.add(new ResourceModels("478385FB732440748D9A4CBAC58598F0", "6FDCE02E57C04663B966D78ECAFF5491", "资源互斥管理", 3));
        allNodes.add(new ResourceModels("19D1D67EAE1B4482A3959D69DBA4D612", "1F0102827B214E4CA94BA05D7E2DD0D5", "权限管理", 2));
        allNodes.add(new ResourceModels("51FDEA20607248FC8A3FB5CDEF99496B", "19D1D67EAE1B4482A3959D69DBA4D612", "业务角色分组", 3));
        allNodes.add(new ResourceModels("FA9D37EB3B4346EB8B01F35BAA325DD9", "19D1D67EAE1B4482A3959D69DBA4D612", "业务角色维护", 3));
        allNodes.add(new ResourceModels("19AFFEA20B7F4063B32864DDF688E09C", "19D1D67EAE1B4482A3959D69DBA4D612", "组织角色维护", 3));

        List<ResourceModels> trees = buildByRecursive(allNodes, "-1");
        System.out.println("返回数据:" + trees);
    }
}
