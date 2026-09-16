package com.codemonk.common.arch;

import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.filter.OncePerRequestFilter;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

class ArchitectureQualityTest_14 {

    private JavaClasses importedClasses;

    @BeforeEach
    void setUp() {
        importedClasses = ArchTestImports.importMainClasses("com.codemonk.common");
    }

    @Test
    @DisplayName("Servlet filters should extend OncePerRequestFilter")
    void servletFiltersShouldExtendOncePerRequestFilter() {
        classes()
                .that().resideInAPackage("..filter..")
                .should().beAssignableTo(OncePerRequestFilter.class)
                .because("request filters should execute once per request")
                .check(importedClasses);
    }
}