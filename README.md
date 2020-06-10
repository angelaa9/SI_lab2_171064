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

#### Објаснување на тестовите од TestEveryPath:

Направени се тестови за сите можни патеки, во овој случај има вкупно 7.
* Тест1: како влез за user имаме null, што не е дозволено и веднаш враќа false.
* Тест2: на влез за username имаме null, и понатака не се прави проверка на останатите барања и враќа false.
* Тест3: овој тест враќа true бидејќи username, password имаат вредност, email ги содржи потребните барања ("@", ".")и притоа во allUsers го има конкретниот user.
* Тест4: не може да се случи бидејќи претходно се проверува дали emailot е null, така што сигурно барем еднаш ќе го измине for.
* Тест5: овој тест враќа false бидејќи username, password имаат вредност, но email не го содржи потребното барање ("."). Иако во allUsers го има конкретниот user.
* Тест6: овој тест враќа false бидејќи username, password имаат вредност, но email не го содржи потребното барање ("@"). Иако во allUsers го има конкретниот user.
* Тест7: овој тест враќа false бидејќи username, password имаат вредност, но email не ги содржи потребните барања ("@","."). Иако во allUsers го има конкретниот user.

#### Објаснување на тестовите од multipleConditionsTest:

Прво имаме тест за првиот multiple condition услов кој се состои од 2 логички оператори && и ги тестираме следниве 3 тест случаи:
* F && X && X - доколку првиот дел од условот не е исполнет, понатаму не се проверуваат останатите.
* T && F && X - иако првиот дел од условот е исполнет, односно имаме име на корисник, вториот дел не е, односно мејлот е null. Третиот дел не се прегледува.
* T && T && F - иако првиот и вториот дел од условот се исполнети, односно имаме има на корисник и мејл, корисникот го нема во листата на сите корисници.

Вториот multiple condition се состои од еден логички оператор && и ги тестираме следниве 2 случаи:
* F && X - кога првиот дел од условот е неточен тогаш вториот дел не се ни прегледува. (мејлот не содржи "@")
* T && F - случај кога првиот дел е точен, а вториот неточен. (мејлот содржи "@", но не и ".")

Третиот multiple condition се состои од еден логички оператор && и ги тестираме следниве 2 случаи:
* F && X - кога првиот дел од условот е неточен тогаш вториот дел не се ни прегледува. (мејлот не содржи "@")
* T && F - случај кога првиот дел е точен, а вториот неточен. (мејлот содржи "@", но не и ".")
