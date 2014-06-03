package com.thesischecker.services.interfaces;

import com.thesischecker.dto.ResourceEntity;

import java.util.List;

/**
 * Resources service interface
 * @author Tomasz Morek
 */
public interface IResourcesService {

    List<ResourceEntity> find();
}
