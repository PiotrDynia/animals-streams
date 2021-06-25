Posiadasz plik w formacie tekstowym o nazwie mammals.txt (którego nie wolno
edytować!). Składa się on z informacji o zwierzętach (39 gatunków ssaków z
opisanymi jedenastoma cechami) w następującej postaci:

species - nazwa gatunku ssaka (String)
body_wt - całkowita masa ciała ssaka (kg, double)
brain_wt - masa mózgu ssaka (kg, double)
non_dreaming - liczba godzin bezsennego snu (double)
dreaming - liczba godzin śniącego snu (double)
total_sleep - całkowita liczba godzin snu (double)
life_span - długość życia (w latach, double)
gestation - czas ciąży (dni, double)
predation - wskaźnik prawdopodobieństwa polowania na ssaka.
1 = najmniej podatne na ofiary, 5 = najprawdopodobniej będzie ofiarą (int)

exposure - wskaźnik ekspozycji ssaka podczas snu. 1 = najmniej narażony
(np. Śpi w dobrze chronionym legowisku), 5 = najbardziej narażone (int)

danger - indeks tego, jak duże niebezpieczeństwo grozi ssakowi ze strony
innych zwierząt. Indeks ten jest oparty na Predation and Exposure.
1 = najmniejsze zagrożenie ze strony innych zwierząt, 5 = największe
zagrożenie ze strony innych zwierząt (int)

Na początek musisz stworzyć Mapę przechowującą jako klucz nazwę ssaka, a
jako wartość klasę którą sam stworzysz.
Klasa ma posiadać dziesięć pól dotyczących charakterystyk zwierzęcia (poza jego
nazwą oczywiście, mającą już być kluczem mapy) o takim typie jaki jest podany
w nawiasach przy opisie danych.
Za pomocą jednego strumienia wczytaj dane z pliku do tej mapy. Zadbaj o to aby
dane w stworzonej mapie były posortowane pod względem długości napisu
klucza (tak, to będzie całkiem duży strumień z wieloma operacjami). Wartości
NA zastąp zerami.
Wydrukuj tę mapę na konsoli zastępując zera napisem unknown.

Za pomocą strumieni (jeden strumień na każdy punkt):
- Znajdź zwierzę z największą całkowitą masą ciała (bez sorted())
- Znajdź 3 zwierzęta z najwyższym współczynnikiem snu sennego do
całkowitego czasu snu, podaj jaki procent czasu snu to sny, pomijaj ssaki
z dowolnym z tych współczynników równemu 0
- Znajdź wszystkie zwierzęta żyjące powyżej średniej życia zwierząt
z mapy, bez sorted()
- Zbierz wartości tej mapy do listy i spraw żeby za pomocą sorted(), bez
żadnych dodatkowych argumentów wywołania tej metody, elementy tej
listy były posortowane pod względem masy ciała zwierzęcia malejąco.
Ogranicz tę listę do trzech elementów (o największych wartościach masy
mózgu) i wydrukuj ją na ekran (drukowanie można zrealizować poza
strumieniem).

Wyobraź sobie teraz, że te 3 zwierzęta których dotyczą te dane znajdują się
w ZOO. Są one tam oczywiście karmione przez opiekunów, ale oczywiście też
spalają pewną energię (masę) w trakcie dnia.
Zadanie będzie polegało na stworzeniu zsynchronizowanego programu
wielowątkowego symulującego zmieniającą się wagę zwierząt. Wszystkie
stworzone wątki w zadaniu mają działać współbieżnie. 

Założenia:
Zwierzęta karmione są dwa razy dziennie, a porcja podawanego jedzenia
pozwala na uzyskanie energii pozwalającej zwiększyć masę zwierzęcia
o wartość z przedziału od 0.5% do 2% aktualnej jego masy
Zwierzę spala tyle kalorii dziennie, że pozwala to na utracenie 2.8% masy
własnej, czyli pomiędzy karmieniami, zwierzę spala dokładnie połowę
masy dziennego zapotrzebowania na energię (1.4%), oznacza to, że po
każdym karmieniu musi nastąpić spalenie energii
Eksperyment ma symulować rok czasu trwania pomiarów, po tym czasie
musimy porównać masę zwierząt przed i po
We wszystkich obliczeniach wewnątrz wątków odnosimy się do danych
wyciąganych bezpośrednio z listy
Każdy obrót wątków powinien być wzbogacony o jakieś informacje
dotyczące tego co się dzieje i aktualnych danych
Pomiędzy zaktualizowaniem masy zwierzęcia, a spaleniem jej części
należy uśpić wątek na 1/10 sekundy
Dostęp do zasobów ma być zsynchronizowany
Nie interesuje nas nazwa zwierzęcia, zresztą nie ma jej nawet w tej liście.
Eksperyment można przeprowadzić dla dowolnej liczby zwierząt z listy,
nawet dla tylko jednego. 
