#Forex Predictor
#A Forex prediction application

Projekt zespołowy - sp. Aplikacje internetowe, grupa 1
Dariusz Burczynski
Paweł Chmiell
Yauheni Dzianisau
Maciej Głowacki

O programie
Nasza aplikacja zajmuje się przewidywaniem zachowania akcji firm na podstawie danych zgromadzonych przez lata. Pod uwagę brane są ceny akcji z otwarcia oraz zamknięcia giełdy poszczególnych dni. Dzięki użyciu technologii machine learning w prosty sposób możemy założyć w jaki sposób zachowają się akcje w przyszłości.

Funkcje programu
Główną funkcją programu jest przewidywanie zmian na rynku walutowym Forex z wykorzystaniem technologii uczenia maszynowego. Historyczne dane wymagane do tworzenia modeli są pobierane za pomocą użytego w programie API oraz automatycznie umieszczane w bazie danych. Możliwe jest generowanie i wyświetlanie modeli giełdowych dla danych historycznych, oraz generowanie i wyświetlanie rekomendacji  kupna dla danej waluty. Dostępne jest graficzne interpretowanie modeli w postaci wykresów. 

Program ma formę aplikacji internetowej z funkcjonalnością kont użytkowników o różnych poziomach dostępu i uprawnień. Użytkownicy posiadają dostęp do wygenerowanych modeli i opartych o nie rekomendacji. Dane historyczne gromadzone w bazie danych pozwalają użytkownikom na tworzenie indywidualnych wykresów w zakresie czasowym maksymalnie do trzydziestu dni wstecz.

Hasła użytkowników zapisywanych w bazie danych są dodatkowo zabezpieczone hashowaniem zapewnionym przez bCryptPasswordEncoder. Tworzone konta mają dwa poziomy uprawnień – użytkownik i administrator. Autentykacja na poziomie użytkownika zapewnia dostęp do podstawowej funkcjonalności programu – przewidywań giełdowych oraz wykresów danych historycznych. Autentykacja na poziomie administratora umożliwia dostęp do zaawansowanych ustawień działania programu, takich jak ustawienia odświeżania danych, ręczne odświeżenie danych, czy ustawienia algorytmów uczenia maszynowego.





Języki wykorzystane w projekcie
•	Java
•	Python
•	SQL
•	HTML

Technologie wykorzystane w projekcie
•	MongoDB -  otwarty, nierelacyjny system zarządzania bazą danych napisany w języku C++. Charakteryzuje się dużą skalowalnością, wydajnością oraz brakiem ściśle zdefiniowanej struktury obsługiwanych baz danych. Zamiast tego dane składowane są jako dokumenty w stylu JSON, co umożliwia aplikacjom bardziej naturalne ich przetwarzanie, przy zachowaniu możliwości tworzenia hierarchii oraz indeksowania.
•	World Trading Data API – interfejs pozwalający na pobieranie dostarczanych w czasie rzeczywistym oraz historycznych danych dotyczących światowych rynków,
•	Spring – wieloprojektowa platforma dedykowana do tworzenia aplikacji w języku Java.
o	Spring MVC 
o	Spring Data 
o	Spring Web 
o	Spring Security
