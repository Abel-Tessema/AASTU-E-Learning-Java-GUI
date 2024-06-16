package controllers;

import exceptions.CoursesFetchException;
import models.Material;
import services.MaterialService;

import java.util.List;

public class MaterialController {
    private final MaterialService materialService = new MaterialService();
    private List<Material> materials;

    public String fetchAllMaterials(int courseId) {
        try {
            this.materials = materialService.fetchAllMaterials(courseId);
            return "";
        } catch (CoursesFetchException e) {
            return e.getMessage();
        }
    }

    public List<Material> getMaterials() {
        return materials;
    }
}
