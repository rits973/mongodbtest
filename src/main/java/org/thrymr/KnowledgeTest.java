/**
 * 
 */
package org.thrymr;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;


/**
 * @author thrymr
 *
 */
public class KnowledgeTest {

    @Test

    public void testAskQuestion() throws Exception {

        Knowledge knowledge = new Knowledge();

        String answer = knowledge.askQuestion("question?");

        assertThat(answer, is("The answer to 'question?' is: 42"));

        setFinalStaticField(Knowledge.class, "ANSWER", 41);

        answer = knowledge.askQuestion("question?");

        assertThat(answer, is("The answer to 'question?' is: 41"));

    }

    private static void setFinalStaticField(Class<?> clazz, String fieldName, Object value)

            throws ReflectiveOperationException {

        Field field = clazz.getDeclaredField(fieldName);

        field.setAccessible(true);

        Field modifiers = Field.class.getDeclaredField("modifiers");

        modifiers.setAccessible(true);

        modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        field.set(null, value);

    }
}

 class Knowledge {

    private static final Integer ANSWER = 42;

    public String askQuestion(String question) {

        return "The answer to '" + question + "' is: " + ANSWER;

    }

}