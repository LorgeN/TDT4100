package org.tanberg.oving5;

import com.google.common.base.Objects;
import junit.framework.TestCase;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

import java.util.Collection;
import java.util.Collections;

public class PersonTest extends TestCase {

    private Person hallvard;
    private Person marit;
    private Person jens;
    private Person anne;

    private Person _init_hallvard() {
      return new Person("Hallvard", 'M');
    }

    private Person _init_marit() {
      return new Person("Marit", 'F');
    }

    private Person _init_jens() {
      return new Person("Jens", 'M');
    }

    private Person _init_anne() {
      return new Person("Anne", 'F');
    }

    @Override
    protected void setUp() {
        hallvard = _init_hallvard();
        marit = _init_marit();
        jens = _init_jens();
        anne = _init_anne();

    }

    private void hasChildren(final Person person, final Collection<?> children) {
        String _plus = (person + " must have ");
        int _size = children.size();
        String _plus_1 = (_plus + Integer.valueOf(_size));
        String _plus_2 = (_plus_1 + " children");
        int _size_1 = children.size();
        int _childCount = person.getChildCount();
        TestCase.assertEquals(_plus_2, _size_1, _childCount);
        for (final Object child : children) {
            {
                boolean found = false;
                int i = 0;
                while ((i < person.getChildCount())) {
                    {
                        Person _child = person.getChild(i);
                        boolean _equals = Objects.equal(child, _child);
                        if (_equals) {
                            found = true;
                        }
                        i++;
                    }
                }
                String _plus_3 = (person + " must have ");
                String _plus_4 = (_plus_3 + child);
                String _plus_5 = (_plus_4 + " as child");
                TestCase.assertTrue(_plus_5, found);
            }
        }
    }

    public void testConstructor() {
        _test__constructor_transitions0_effects0_state();

    }

    public void testFarskapIllegalArgumentException() {
        try {
            _transition_exprAction__farskapIllegalArgumentException_transitions0_actions0();
            fail("IllegalArgumentException should be thrown after jens.father = marit");
        } catch (Exception e) {
            assertTrue("IllegalArgumentException should be thrown after jens.father = marit", e instanceof IllegalArgumentException);
        }
        try {
            _transition_exprAction__farskapIllegalArgumentException_transitions1_actions0();
            fail("IllegalArgumentException should be thrown after anne.father = marit");
        } catch (Exception e_1) {
            assertTrue("IllegalArgumentException should be thrown after anne.father = marit", e_1 instanceof IllegalArgumentException);
        }

    }

    public void testMorskapIllegalArgumentException() {
        try {
            _transition_exprAction__morskapIllegalArgumentException_transitions0_actions0();
            fail("IllegalArgumentException should be thrown after jens.mother = hallvard");
        } catch (Exception e) {
            assertTrue("IllegalArgumentException should be thrown after jens.mother = hallvard", e instanceof IllegalArgumentException);
        }
        try {
            _transition_exprAction__morskapIllegalArgumentException_transitions1_actions0();
            fail("IllegalArgumentException should be thrown after anne.mother = hallvard");
        } catch (Exception e_1) {
            assertTrue("IllegalArgumentException should be thrown after anne.mother = hallvard", e_1 instanceof IllegalArgumentException);
        }

    }

    public void testSelvfarskapIllegalArgumentException() {
        try {
            _transition_exprAction__selvfarskapIllegalArgumentException_transitions0_actions0();
            fail("IllegalArgumentException should be thrown after jens.father = jens");
        } catch (Exception e) {
            assertTrue("IllegalArgumentException should be thrown after jens.father = jens", e instanceof IllegalArgumentException);
        }

    }

    public void testSelvmorskapIllegalArgumentException() {
        try {
            _transition_exprAction__selvmorskapIllegalArgumentException_transitions0_actions0();
            fail("IllegalArgumentException should be thrown after anne.mother = anne");
        } catch (Exception e) {
            assertTrue("IllegalArgumentException should be thrown after anne.mother = anne", e instanceof IllegalArgumentException);
        }

    }

    public void testFarskapSetFather() {
        _transition_exprAction__farskapSetFather_transitions0_actions0();
        _test__farskapSetFather_transitions0_effects0_state();
        _transition_exprAction__farskapSetFather_transitions1_actions0();
        _test__farskapSetFather_transitions1_effects0_state();

    }

    public void testFarskapAddChild() {
        _transition_exprAction__farskapAddChild_transitions0_actions0();
        _test__farskapAddChild_transitions0_effects0_state();
        _transition_exprAction__farskapAddChild_transitions1_actions0();
        _test__farskapAddChild_transitions1_effects0_state();

    }

    public void testMorskapSetMother() {
        _transition_exprAction__morskapSetMother_transitions0_actions0();
        _test__morskapSetMother_transitions0_effects0_state();
        _transition_exprAction__morskapSetMother_transitions1_actions0();
        _test__morskapSetMother_transitions1_effects0_state();

    }

    public void testMorskapAddChild() {
        _transition_exprAction__morskapAddChild_transitions0_actions0();
        _test__morskapAddChild_transitions0_effects0_state();
        _transition_exprAction__morskapAddChild_transitions1_actions0();
        _test__morskapAddChild_transitions1_effects0_state();

    }

    public void testFarbytteSetFather() {
        _transition_exprAction__farbytteSetFather_transitions0_actions0();
        _test__farbytteSetFather_transitions0_effects0_state();
        _transition_exprAction__farbytteSetFather_transitions1_actions0();
        _test__farbytteSetFather_transitions1_effects0_state();

    }

    public void testFarbytteAddChild() {
        _transition_exprAction__farbytteAddChild_transitions0_actions0();
        _test__farbytteAddChild_transitions0_effects0_state();
        _transition_exprAction__farbytteAddChild_transitions1_actions0();
        _test__farbytteAddChild_transitions1_effects0_state();

    }

    public void testMorbytteSetMother() {
        _transition_exprAction__morbytteSetMother_transitions0_actions0();
        _test__morbytteSetMother_transitions0_effects0_state();
        _transition_exprAction__morbytteSetMother_transitions1_actions0();
        _test__morbytteSetMother_transitions1_effects0_state();

    }

    public void testMorbytteAddChild() {
        _transition_exprAction__morbytteAddChild_transitions0_actions0();
        _test__morbytteAddChild_transitions0_effects0_state();
        _transition_exprAction__morbytteAddChild_transitions1_actions0();
        _test__morbytteAddChild_transitions1_effects0_state();

    }

    private void _test__constructor_transitions0_effects0_state() {
        _test__constructor_transitions0_effects0_state_objectTests0_test(hallvard);
        _test__constructor_transitions0_effects0_state_objectTests1_test(marit);
        _test__constructor_transitions0_effects0_state_objectTests2_test(jens);
        _test__constructor_transitions0_effects0_state_objectTests3_test(anne);

    }

    private void _test__constructor_transitions0_effects0_state_objectTests0_test(final Person it) {

        Person _father = it.getFather();
        assertEquals("father == null failed", null, _father);

        Person _mother = it.getMother();
        assertEquals("mother == null failed", null, _mother);
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList()));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[]) failed: " + error.getMessage());
        }

    }

    private void _test__constructor_transitions0_effects0_state_objectTests1_test(final Person it) {

        Person _father = it.getFather();
        assertEquals("father == null failed", null, _father);

        Person _mother = it.getMother();
        assertEquals("mother == null failed", null, _mother);
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList()));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[]) failed: " + error.getMessage());
        }

    }

    private void _test__constructor_transitions0_effects0_state_objectTests2_test(final Person it) {

        Person _father = it.getFather();
        assertEquals("father == null failed", null, _father);

        Person _mother = it.getMother();
        assertEquals("mother == null failed", null, _mother);
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList()));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[]) failed: " + error.getMessage());
        }

    }

    private void _test__constructor_transitions0_effects0_state_objectTests3_test(final Person it) {

        Person _father = it.getFather();
        assertEquals("father == null failed", null, _father);

        Person _mother = it.getMother();
        assertEquals("mother == null failed", null, _mother);
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList()));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[]) failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__farskapIllegalArgumentException_transitions0_actions0() {
        try {

            this.jens.setFather(this.marit);
        } catch (junit.framework.AssertionFailedError error) {
            fail("jens.father = marit failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__farskapIllegalArgumentException_transitions1_actions0() {
        try {

            this.anne.setFather(this.marit);
        } catch (junit.framework.AssertionFailedError error) {
            fail("anne.father = marit failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__morskapIllegalArgumentException_transitions0_actions0() {
        try {

            this.jens.setMother(this.hallvard);
        } catch (junit.framework.AssertionFailedError error) {
            fail("jens.mother = hallvard failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__morskapIllegalArgumentException_transitions1_actions0() {
        try {

            this.anne.setMother(this.hallvard);
        } catch (junit.framework.AssertionFailedError error) {
            fail("anne.mother = hallvard failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__selvfarskapIllegalArgumentException_transitions0_actions0() {
        try {

            this.jens.setFather(this.jens);
        } catch (junit.framework.AssertionFailedError error) {
            fail("jens.father = jens failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__selvmorskapIllegalArgumentException_transitions0_actions0() {
        try {

            this.anne.setMother(this.anne);
        } catch (junit.framework.AssertionFailedError error) {
            fail("anne.mother = anne failed: " + error.getMessage());
        }

    }

    private void _transition_exprAction__farskapSetFather_transitions0_actions0() {
        try {

            this.jens.setFather(this.hallvard);
        } catch (junit.framework.AssertionFailedError error) {
            fail("jens.father = hallvard failed: " + error.getMessage());
        }

    }

    private void _test__farskapSetFather_transitions0_effects0_state() {
        _test__farskapSetFather_transitions0_effects0_state_objectTests0_test(hallvard);
        _test__farskapSetFather_transitions0_effects0_state_objectTests1_test(jens);

    }

    private void _test__farskapSetFather_transitions0_effects0_state_objectTests0_test(final Person it) {

        Person _father = it.getFather();
        assertEquals("father == null failed after jens.father = hallvard", null, _father);

        Person _mother = it.getMother();
        assertEquals("mother == null failed after jens.father = hallvard", null, _mother);
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList(this.jens)));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[jens]) failed after jens.father = hallvard: " + error.getMessage());
        }

    }

    private void _test__farskapSetFather_transitions0_effects0_state_objectTests1_test(final Person it) {

        Person _father = it.getFather();
        assertEquals("father == hallvard failed after jens.father = hallvard", this.hallvard, _father);

        Person _mother = it.getMother();
        assertEquals("mother == null failed after jens.father = hallvard", null, _mother);
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList()));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[]) failed after jens.father = hallvard: " + error.getMessage());
        }

    }

    private void _transition_exprAction__farskapSetFather_transitions1_actions0() {
        try {

            this.anne.setFather(this.hallvard);
        } catch (junit.framework.AssertionFailedError error) {
            fail("anne.father = hallvard failed: " + error.getMessage());
        }

    }

    private void _test__farskapSetFather_transitions1_effects0_state() {
        _test__farskapSetFather_transitions1_effects0_state_objectTests0_test(hallvard);
        _test__farskapSetFather_transitions1_effects0_state_objectTests1_test(jens);
        _test__farskapSetFather_transitions1_effects0_state_objectTests2_test(anne);

    }

    private void _test__farskapSetFather_transitions1_effects0_state_objectTests0_test(final Person it) {

        Person _father = it.getFather();
        assertEquals("father == null failed after anne.father = hallvard", null, _father);

        Person _mother = it.getMother();
        assertEquals("mother == null failed after anne.father = hallvard", null, _mother);
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList(this.jens, this.anne)));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[jens, anne]) failed after anne.father = hallvard: " + error.getMessage());
        }

    }

    private void _test__farskapSetFather_transitions1_effects0_state_objectTests1_test(final Person it) {

        Person _father = it.getFather();
        assertEquals("father == hallvard failed after anne.father = hallvard", this.hallvard, _father);

        Person _mother = it.getMother();
        assertEquals("mother == null failed after anne.father = hallvard", null, _mother);
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList()));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[]) failed after anne.father = hallvard: " + error.getMessage());
        }

    }

    private void _test__farskapSetFather_transitions1_effects0_state_objectTests2_test(final Person it) {

        Person _father = it.getFather();
        assertEquals("father == hallvard failed after anne.father = hallvard", this.hallvard, _father);

        Person _mother = it.getMother();
        assertEquals("mother == null failed after anne.father = hallvard", null, _mother);
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList()));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[]) failed after anne.father = hallvard: " + error.getMessage());
        }

    }

    private void _transition_exprAction__farskapAddChild_transitions0_actions0() {
        try {

            this.hallvard.addChild(this.jens);
        } catch (junit.framework.AssertionFailedError error) {
            fail("hallvard.addChild(jens) failed: " + error.getMessage());
        }

    }

    private void _test__farskapAddChild_transitions0_effects0_state() {
        _test__farskapAddChild_transitions0_effects0_state_objectTests0_test(hallvard);
        _test__farskapAddChild_transitions0_effects0_state_objectTests1_test(jens);

    }

    private void _test__farskapAddChild_transitions0_effects0_state_objectTests0_test(final Person it) {

        Person _father = it.getFather();
        assertEquals("father == null failed after hallvard.addChild(jens)", null, _father);

        Person _mother = it.getMother();
        assertEquals("mother == null failed after hallvard.addChild(jens)", null, _mother);
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList(this.jens)));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[jens]) failed after hallvard.addChild(jens): " + error.getMessage());
        }

    }

    private void _test__farskapAddChild_transitions0_effects0_state_objectTests1_test(final Person it) {

        Person _father = it.getFather();
        assertEquals("father == hallvard failed after hallvard.addChild(jens)", this.hallvard, _father);

        Person _mother = it.getMother();
        assertEquals("mother == null failed after hallvard.addChild(jens)", null, _mother);
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList()));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[]) failed after hallvard.addChild(jens): " + error.getMessage());
        }

    }

    private void _transition_exprAction__farskapAddChild_transitions1_actions0() {
        try {

            this.hallvard.addChild(this.anne);
        } catch (junit.framework.AssertionFailedError error) {
            fail("hallvard.addChild(anne) failed: " + error.getMessage());
        }

    }

    private void _test__farskapAddChild_transitions1_effects0_state() {
        _test__farskapAddChild_transitions1_effects0_state_objectTests0_test(hallvard);
        _test__farskapAddChild_transitions1_effects0_state_objectTests1_test(jens);
        _test__farskapAddChild_transitions1_effects0_state_objectTests2_test(anne);

    }

    private void _test__farskapAddChild_transitions1_effects0_state_objectTests0_test(final Person it) {

        Person _father = it.getFather();
        assertEquals("father == null failed after hallvard.addChild(anne)", null, _father);

        Person _mother = it.getMother();
        assertEquals("mother == null failed after hallvard.addChild(anne)", null, _mother);
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList(this.jens, this.anne)));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[jens, anne]) failed after hallvard.addChild(anne): " + error.getMessage());
        }

    }

    private void _test__farskapAddChild_transitions1_effects0_state_objectTests1_test(final Person it) {

        Person _father = it.getFather();
        assertEquals("father == hallvard failed after hallvard.addChild(anne)", this.hallvard, _father);

        Person _mother = it.getMother();
        assertEquals("mother == null failed after hallvard.addChild(anne)", null, _mother);
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList()));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[]) failed after hallvard.addChild(anne): " + error.getMessage());
        }

    }

    private void _test__farskapAddChild_transitions1_effects0_state_objectTests2_test(final Person it) {

        Person _father = it.getFather();
        assertEquals("father == hallvard failed after hallvard.addChild(anne)", this.hallvard, _father);

        Person _mother = it.getMother();
        assertEquals("mother == null failed after hallvard.addChild(anne)", null, _mother);
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList()));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[]) failed after hallvard.addChild(anne): " + error.getMessage());
        }

    }

    private void _transition_exprAction__morskapSetMother_transitions0_actions0() {
        try {

            this.jens.setMother(this.marit);
        } catch (junit.framework.AssertionFailedError error) {
            fail("jens.mother = marit failed: " + error.getMessage());
        }

    }

    private void _test__morskapSetMother_transitions0_effects0_state() {
        _test__morskapSetMother_transitions0_effects0_state_objectTests0_test(marit);
        _test__morskapSetMother_transitions0_effects0_state_objectTests1_test(jens);

    }

    private void _test__morskapSetMother_transitions0_effects0_state_objectTests0_test(final Person it) {

        Person _father = it.getFather();
        assertEquals("father == null failed after jens.mother = marit", null, _father);

        Person _mother = it.getMother();
        assertEquals("mother == null failed after jens.mother = marit", null, _mother);
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList(this.jens)));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[jens]) failed after jens.mother = marit: " + error.getMessage());
        }

    }

    private void _test__morskapSetMother_transitions0_effects0_state_objectTests1_test(final Person it) {

        Person _father = it.getFather();
        assertEquals("father == null failed after jens.mother = marit", null, _father);

        Person _mother = it.getMother();
        assertEquals("mother == marit failed after jens.mother = marit", this.marit, _mother);
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList()));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[]) failed after jens.mother = marit: " + error.getMessage());
        }

    }

    private void _transition_exprAction__morskapSetMother_transitions1_actions0() {
        try {

            this.anne.setMother(this.marit);
        } catch (junit.framework.AssertionFailedError error) {
            fail("anne.mother = marit failed: " + error.getMessage());
        }

    }

    private void _test__morskapSetMother_transitions1_effects0_state() {
        _test__morskapSetMother_transitions1_effects0_state_objectTests0_test(marit);
        _test__morskapSetMother_transitions1_effects0_state_objectTests1_test(jens);
        _test__morskapSetMother_transitions1_effects0_state_objectTests2_test(anne);

    }

    private void _test__morskapSetMother_transitions1_effects0_state_objectTests0_test(final Person it) {

        Person _father = it.getFather();
        assertEquals("father == null failed after anne.mother = marit", null, _father);

        Person _mother = it.getMother();
        assertEquals("mother == null failed after anne.mother = marit", null, _mother);
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList(this.jens, this.anne)));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[jens, anne]) failed after anne.mother = marit: " + error.getMessage());
        }

    }

    private void _test__morskapSetMother_transitions1_effects0_state_objectTests1_test(final Person it) {

        Person _father = it.getFather();
        assertEquals("father == null failed after anne.mother = marit", null, _father);

        Person _mother = it.getMother();
        assertEquals("mother == marit failed after anne.mother = marit", this.marit, _mother);
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList()));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[]) failed after anne.mother = marit: " + error.getMessage());
        }

    }

    private void _test__morskapSetMother_transitions1_effects0_state_objectTests2_test(final Person it) {

        Person _father = it.getFather();
        assertEquals("father == null failed after anne.mother = marit", null, _father);

        Person _mother = it.getMother();
        assertEquals("mother == marit failed after anne.mother = marit", this.marit, _mother);
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList()));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[]) failed after anne.mother = marit: " + error.getMessage());
        }

    }

    private void _transition_exprAction__morskapAddChild_transitions0_actions0() {
        try {

            this.marit.addChild(this.jens);
        } catch (junit.framework.AssertionFailedError error) {
            fail("marit.addChild(jens) failed: " + error.getMessage());
        }

    }

    private void _test__morskapAddChild_transitions0_effects0_state() {
        _test__morskapAddChild_transitions0_effects0_state_objectTests0_test(marit);
        _test__morskapAddChild_transitions0_effects0_state_objectTests1_test(jens);

    }

    private void _test__morskapAddChild_transitions0_effects0_state_objectTests0_test(final Person it) {

        Person _father = it.getFather();
        assertEquals("father == null failed after marit.addChild(jens)", null, _father);

        Person _mother = it.getMother();
        assertEquals("mother == null failed after marit.addChild(jens)", null, _mother);
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList(this.jens)));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[jens]) failed after marit.addChild(jens): " + error.getMessage());
        }

    }

    private void _test__morskapAddChild_transitions0_effects0_state_objectTests1_test(final Person it) {

        Person _father = it.getFather();
        assertEquals("father == null failed after marit.addChild(jens)", null, _father);

        Person _mother = it.getMother();
        assertEquals("mother == marit failed after marit.addChild(jens)", this.marit, _mother);
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList()));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[]) failed after marit.addChild(jens): " + error.getMessage());
        }

    }

    private void _transition_exprAction__morskapAddChild_transitions1_actions0() {
        try {

            this.marit.addChild(this.anne);
        } catch (junit.framework.AssertionFailedError error) {
            fail("marit.addChild(anne) failed: " + error.getMessage());
        }

    }

    private void _test__morskapAddChild_transitions1_effects0_state() {
        _test__morskapAddChild_transitions1_effects0_state_objectTests0_test(marit);
        _test__morskapAddChild_transitions1_effects0_state_objectTests1_test(jens);
        _test__morskapAddChild_transitions1_effects0_state_objectTests2_test(anne);

    }

    private void _test__morskapAddChild_transitions1_effects0_state_objectTests0_test(final Person it) {

        Person _father = it.getFather();
        assertEquals("father == null failed after marit.addChild(anne)", null, _father);

        Person _mother = it.getMother();
        assertEquals("mother == null failed after marit.addChild(anne)", null, _mother);
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList(this.jens, this.anne)));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[jens, anne]) failed after marit.addChild(anne): " + error.getMessage());
        }

    }

    private void _test__morskapAddChild_transitions1_effects0_state_objectTests1_test(final Person it) {

        Person _father = it.getFather();
        assertEquals("father == null failed after marit.addChild(anne)", null, _father);

        Person _mother = it.getMother();
        assertEquals("mother == marit failed after marit.addChild(anne)", this.marit, _mother);
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList()));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[]) failed after marit.addChild(anne): " + error.getMessage());
        }

    }

    private void _test__morskapAddChild_transitions1_effects0_state_objectTests2_test(final Person it) {

        Person _father = it.getFather();
        assertEquals("father == null failed after marit.addChild(anne)", null, _father);

        Person _mother = it.getMother();
        assertEquals("mother == marit failed after marit.addChild(anne)", this.marit, _mother);
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList()));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[]) failed after marit.addChild(anne): " + error.getMessage());
        }

    }

    private void _transition_exprAction__farbytteSetFather_transitions0_actions0() {
        try {

            this.anne.setFather(this.jens);
        } catch (junit.framework.AssertionFailedError error) {
            fail("anne.father = jens failed: " + error.getMessage());
        }

    }

    private void _test__farbytteSetFather_transitions0_effects0_state() {
        _test__farbytteSetFather_transitions0_effects0_state_objectTests0_test(anne);
        _test__farbytteSetFather_transitions0_effects0_state_objectTests1_test(jens);

    }

    private void _test__farbytteSetFather_transitions0_effects0_state_objectTests0_test(final Person it) {

        Person _father = it.getFather();
        assertEquals("father == jens failed after anne.father = jens", this.jens, _father);

    }

    private void _test__farbytteSetFather_transitions0_effects0_state_objectTests1_test(final Person it) {
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList(this.anne)));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[anne]) failed after anne.father = jens: " + error.getMessage());
        }

    }

    private void _transition_exprAction__farbytteSetFather_transitions1_actions0() {
        try {

            this.anne.setFather(this.hallvard);
        } catch (junit.framework.AssertionFailedError error) {
            fail("anne.father = hallvard failed: " + error.getMessage());
        }

    }

    private void _test__farbytteSetFather_transitions1_effects0_state() {
        _test__farbytteSetFather_transitions1_effects0_state_objectTests0_test(anne);
        _test__farbytteSetFather_transitions1_effects0_state_objectTests1_test(jens);
        _test__farbytteSetFather_transitions1_effects0_state_objectTests2_test(hallvard);

    }

    private void _test__farbytteSetFather_transitions1_effects0_state_objectTests0_test(final Person it) {

        Person _father = it.getFather();
        assertEquals("father == hallvard failed after anne.father = hallvard", this.hallvard, _father);

    }

    private void _test__farbytteSetFather_transitions1_effects0_state_objectTests1_test(final Person it) {
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList()));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[]) failed after anne.father = hallvard: " + error.getMessage());
        }

    }

    private void _test__farbytteSetFather_transitions1_effects0_state_objectTests2_test(final Person it) {
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList(this.anne)));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[anne]) failed after anne.father = hallvard: " + error.getMessage());
        }

    }

    private void _transition_exprAction__farbytteAddChild_transitions0_actions0() {
        try {

            this.jens.addChild(this.anne);
        } catch (junit.framework.AssertionFailedError error) {
            fail("jens.addChild(anne) failed: " + error.getMessage());
        }

    }

    private void _test__farbytteAddChild_transitions0_effects0_state() {
        _test__farbytteAddChild_transitions0_effects0_state_objectTests0_test(anne);
        _test__farbytteAddChild_transitions0_effects0_state_objectTests1_test(jens);

    }

    private void _test__farbytteAddChild_transitions0_effects0_state_objectTests0_test(final Person it) {

        Person _father = it.getFather();
        assertEquals("father == jens failed after jens.addChild(anne)", this.jens, _father);

    }

    private void _test__farbytteAddChild_transitions0_effects0_state_objectTests1_test(final Person it) {
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList(this.anne)));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[anne]) failed after jens.addChild(anne): " + error.getMessage());
        }

    }

    private void _transition_exprAction__farbytteAddChild_transitions1_actions0() {
        try {

            this.hallvard.addChild(this.anne);
        } catch (junit.framework.AssertionFailedError error) {
            fail("hallvard.addChild(anne) failed: " + error.getMessage());
        }

    }

    private void _test__farbytteAddChild_transitions1_effects0_state() {
        _test__farbytteAddChild_transitions1_effects0_state_objectTests0_test(anne);
        _test__farbytteAddChild_transitions1_effects0_state_objectTests1_test(jens);
        _test__farbytteAddChild_transitions1_effects0_state_objectTests2_test(hallvard);

    }

    private void _test__farbytteAddChild_transitions1_effects0_state_objectTests0_test(final Person it) {

        Person _father = it.getFather();
        assertEquals("father == hallvard failed after hallvard.addChild(anne)", this.hallvard, _father);

    }

    private void _test__farbytteAddChild_transitions1_effects0_state_objectTests1_test(final Person it) {
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList()));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[]) failed after hallvard.addChild(anne): " + error.getMessage());
        }

    }

    private void _test__farbytteAddChild_transitions1_effects0_state_objectTests2_test(final Person it) {
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList(this.anne)));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[anne]) failed after hallvard.addChild(anne): " + error.getMessage());
        }

    }

    private void _transition_exprAction__morbytteSetMother_transitions0_actions0() {
        try {

            this.jens.setMother(this.anne);
        } catch (junit.framework.AssertionFailedError error) {
            fail("jens.mother = anne failed: " + error.getMessage());
        }

    }

    private void _test__morbytteSetMother_transitions0_effects0_state() {
        _test__morbytteSetMother_transitions0_effects0_state_objectTests0_test(jens);
        _test__morbytteSetMother_transitions0_effects0_state_objectTests1_test(anne);

    }

    private void _test__morbytteSetMother_transitions0_effects0_state_objectTests0_test(final Person it) {

        Person _mother = it.getMother();
        assertEquals("mother == anne failed after jens.mother = anne", this.anne, _mother);

    }

    private void _test__morbytteSetMother_transitions0_effects0_state_objectTests1_test(final Person it) {
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList(this.jens)));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[jens]) failed after jens.mother = anne: " + error.getMessage());
        }

    }

    private void _transition_exprAction__morbytteSetMother_transitions1_actions0() {
        try {

            this.jens.setMother(this.marit);
        } catch (junit.framework.AssertionFailedError error) {
            fail("jens.mother = marit failed: " + error.getMessage());
        }

    }

    private void _test__morbytteSetMother_transitions1_effects0_state() {
        _test__morbytteSetMother_transitions1_effects0_state_objectTests0_test(jens);
        _test__morbytteSetMother_transitions1_effects0_state_objectTests1_test(anne);
        _test__morbytteSetMother_transitions1_effects0_state_objectTests2_test(marit);

    }

    private void _test__morbytteSetMother_transitions1_effects0_state_objectTests0_test(final Person it) {

        Person _mother = it.getMother();
        assertEquals("mother == marit failed after jens.mother = marit", this.marit, _mother);

    }

    private void _test__morbytteSetMother_transitions1_effects0_state_objectTests1_test(final Person it) {
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList()));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[]) failed after jens.mother = marit: " + error.getMessage());
        }

    }

    private void _test__morbytteSetMother_transitions1_effects0_state_objectTests2_test(final Person it) {
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList(this.jens)));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[jens]) failed after jens.mother = marit: " + error.getMessage());
        }

    }

    private void _transition_exprAction__morbytteAddChild_transitions0_actions0() {
        try {

            this.anne.addChild(this.jens);
        } catch (junit.framework.AssertionFailedError error) {
            fail("anne.addChild(jens) failed: " + error.getMessage());
        }

    }

    private void _test__morbytteAddChild_transitions0_effects0_state() {
        _test__morbytteAddChild_transitions0_effects0_state_objectTests0_test(jens);
        _test__morbytteAddChild_transitions0_effects0_state_objectTests1_test(anne);

    }

    private void _test__morbytteAddChild_transitions0_effects0_state_objectTests0_test(final Person it) {

        Person _mother = it.getMother();
        assertEquals("mother == anne failed after anne.addChild(jens)", this.anne, _mother);

    }

    private void _test__morbytteAddChild_transitions0_effects0_state_objectTests1_test(final Person it) {
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList(this.jens)));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[jens]) failed after anne.addChild(jens): " + error.getMessage());
        }

    }

    private void _transition_exprAction__morbytteAddChild_transitions1_actions0() {
        try {

            this.marit.addChild(this.jens);
        } catch (junit.framework.AssertionFailedError error) {
            fail("marit.addChild(jens) failed: " + error.getMessage());
        }

    }

    private void _test__morbytteAddChild_transitions1_effects0_state() {
        _test__morbytteAddChild_transitions1_effects0_state_objectTests0_test(jens);
        _test__morbytteAddChild_transitions1_effects0_state_objectTests1_test(anne);
        _test__morbytteAddChild_transitions1_effects0_state_objectTests2_test(marit);

    }

    private void _test__morbytteAddChild_transitions1_effects0_state_objectTests0_test(final Person it) {

        Person _mother = it.getMother();
        assertEquals("mother == marit failed after marit.addChild(jens)", this.marit, _mother);

    }

    private void _test__morbytteAddChild_transitions1_effects0_state_objectTests1_test(final Person it) {
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList()));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[]) failed after marit.addChild(jens): " + error.getMessage());
        }

    }

    private void _test__morbytteAddChild_transitions1_effects0_state_objectTests2_test(final Person it) {
        try {

            this.hasChildren(it, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList(this.jens)));
        } catch (junit.framework.AssertionFailedError error) {
            fail("hasChildren(#[jens]) failed after marit.addChild(jens): " + error.getMessage());
        }

    }
}
