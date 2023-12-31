package com.moittie.hamsterserver.controllers.helpers;

import jakarta.ws.rs.core.UriInfo;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import java.util.Map;
import java.util.stream.Collectors;

public final class ControllerHelper {

    private ControllerHelper() {
    }

    /**
     * Get query parameters from UriInfo and put them in a map.
     *
     * @param uriInfo Request URI information.
     * @return Query filters.
     */
    public static Map<String, String> getFilters(final UriInfo uriInfo) {
        return uriInfo.getQueryParameters().entrySet().stream()
                .map(entry -> Map.entry(entry.getKey(), entry.getValue().get(0)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    /**
     * Get status code.
     *
     * @param resources Resources.
     * @param <T>       Entity of resources.
     * @return 200 on complete resources or 206 on partial resource.
     */
    public static <T> int getStatus(final Page<T> resources) {
        if (resources.getTotalPages() > 1) {
            return HttpStatus.PARTIAL_CONTENT.value();
        }
        return HttpStatus.OK.value();
    }
}
