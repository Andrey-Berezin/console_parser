# Условие задания

Написать консольную утилиту, получающую на вход несколько .csv файлов (разделитель значений - ';'). 

Первая строка каждого - заголовки значений. 

Результат работы - набор файлов с названиями соответствующими заголовкам и содержимым - уникальными в рамках всей задачи значениями.

Требования: разбор файлов должен производиться многопоточно, реализация должна использовать исключительно jdk (любой версии).

# Реализация

В файлах list_1.csv , list_2.csv находятся тестовые наборы данных. Эти файлы программа считывает с консоли из массива агрументов.

В файле Parser.java реализован основной функционал и многопоточное выполнение метода.

Метод generateFiles() - создает файлы с названиями, соответствующими заголовкам в csv-файлах и содержимым - уникальными значениями из этих файлов. 

Файлы id.txt, name.txt, path.txt, sex.txt, version.txt - файлы, сгенерированные с помощью метода generateFiles().
