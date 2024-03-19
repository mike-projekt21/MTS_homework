Тест кейсы

Тест 1)	Корректная авторизация

а)	Предусловие

    открыть сайт по ссылке: 
    https://frutonyanya.ru/
        
б)	Шаги

    1. Нажать кнопку "Вход"
    2. Ввести логин в поле "E-mail"
    2. Ввести пароль в поле "Пароль"
    3. Нажать кнопку "Войти"

в)	Постусловие теста

    Зафиксировать выплывшее сообщение

г) Входные параметры

    e-mail: yonapo4570@cmheia.com
    пароль: test_password

д) Ожидаемый результат

    Текст в всплывающем окне: "Вы авторизованы!"

Тест 2)	Наличие профиля в результате авторизации 

а)	Предусловие

    открыть сайт по ссылке: 
    https://frutonyanya.ru/

б)	Шаги

    1. Нажать кнопку "Вход"
    2. Ввести логин в поле "E-mail"
    2. Ввести пароль в поле "Пароль"
    3. Нажать кнопку "Войти"
    3. В всплывшем окне нажать кнопку "На главную"

в) Входные параметры

    e-mail: pexofen378@darkse.com
    пароль: test_pass

в)	Постусловие теста

    Выйти из профиля

г) Ожидаемый результат

    В правом верхнем углу страницы вместо кнопок "Вход" и "Регистрация" появилось меню профиля, на которое можно нажать

Тест 3)	(Ручное тестирование, Негативный) Вход с некорректными данными

а)	Предусловие

    открыть сайт по ссылке: 
    https://frutonyanya.ru/

б)	Шаги

    1. Нажать кнопку "Вход"
    2. Ввести логин в поле "E-mail"
    2. Ввести пароль в поле "Пароль"
    3. Нажать кнопку "Войти"

в) Входные параметры

    e-mail: sdfhaw
    пароль: test_pass

г) Ожидаемый результат

    Сообщение: "Адрес электронной почты должен содержать символ "@". В адресе "sdfhaw" отсутствует символ "@"."