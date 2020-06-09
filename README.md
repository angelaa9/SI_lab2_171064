# Втора лабораториска вежба по Софтверско инженерство
## Ангела Шуменковски, бр. на индекс 171064
### Група на код:
Ја добив групата на код 5

### Control Flow Graph

![171064](https://user-images.githubusercontent.com/62511348/84208534-419f1000-aab4-11ea-9ff6-36a57d097542.jpg)

### Цикломатска комплексност
Цикломатската комплексност ја одредуваме така што ги броиме регионите во графот. Може да заклучиме дека цикломатската комплексност е 5 и имаме толку независни патеки.

### Тест случаи според критериумот Every Branch Test
    @Test
    void EveryBranchTest() {
        IllegalArgumentException ex;

        ex = assertThrows(IllegalArgumentException.class, () -> SILab2.function(null));
        assertTrue(ex.getMessage().contains("List length should be greater than 0"));

        assertEquals("#, #, #, #, #", SILab2.function(createList("#, #, #, #, #")));
        assertEquals("#, 2, #, 2, #", SILab2.function(createList("#, 0, #, 0, #")));

    }
### Тест случаи според критериумот Multiple Conditions Test 
    @Test
    void multipleConditionsTest() {
        //if (i - 1 >= 0 && list.get(i - 1).equals("#")) { //9
        //F && X
        //T && F

        IllegalArgumentException ex;
        ex = assertThrows(IllegalArgumentException.class,
                () -> SILab2.function(null));
        assertTrue(ex.getMessage().contains("List length should be greater than 0"));

        assertEquals("0,0,1", SILab2.function(createList("0,0,0,#")));

        //if (i + 1 < list.size() && list.get(i + 1).equals("#")) { //12
        //F && X
        //T && F

        ex = assertThrows(IllegalArgumentException.class,
                () -> SILab2.function(null));
        assertTrue(ex.getMessage().contains("List length should be greater than 0"));

        assertEquals("1,0,0", SILab2.function(createList("#,0,0,0")));
    }
### Објаснување на напишаните unit tests
