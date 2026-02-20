package edu.uoc.ds.adt;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class ArchitectureTest {
    private final JavaClasses importedClasses = new ClassFileImporter().importPackages("edu.uoc.ds.adt");

    @Test
    public void shouldNotUseProhibitedJavaUtilClasses() {
        ArchRule rule = noClasses()
                .should().dependOnClassesThat()
                .haveNameMatching("java\\.util\\.(Vector|TreeSet|Stack|PriorityQueue|LinkedList|LinkedHashSet|Hashtable|HashSet|HashMap|Dictionary|Collections|ArrayList|ArrayDeque|AbstractSet|AbstractSequentialList|AbstractQueue|AbstractMap|AbstractList|AbstractCollection)")
                ;//.allowEmptyShould(true);

        rule.check(importedClasses);
    }

}
