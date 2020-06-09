package br.com.motivo.aristoteles.beans;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.mindmap.DefaultMindmapNode;
import org.primefaces.model.mindmap.MindmapNode;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class MindmapBean implements Serializable {

    private MindmapNode root;
    private MindmapNode selectedNode;

    public MindmapBean() {
        root = new DefaultMindmapNode("google.com", "Google", "FFCC00", false);

        MindmapNode ips = new DefaultMindmapNode("IPs", "IP Nos", "6e9ebf", true);
        MindmapNode ns = new DefaultMindmapNode("NS(s)", "Names", "6e9ebf", true);
        MindmapNode mw = new DefaultMindmapNode("Mw", "Malicious ", "6e9ebf", true);

        root.addNode(ips);
        root.addNode(ns);
        root.addNode(mw);
    }

    public MindmapNode getRoot() {
        return root;
    }

    public void onNodeSelect(SelectEvent event) {
        MindmapNode node = (MindmapNode) event.getObject();
        //load children of select node and add via node.addNode(childNode);
    }

    public void onNodeDblselect(SelectEvent event) {
        this.selectedNode = (MindmapNode) event.getObject();
    }
}