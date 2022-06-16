# TrajectoryInterpolation
## Описание
Студенческий проект, рещающий задачу интерполяции траектории с несколькими точками. Интерполяция траектории производилась по следующим формулам, которые описаны в книге Modern Robotics

<img width="279" alt="Снимок экрана 2022-06-16 в 17 57 06" src="https://user-images.githubusercontent.com/29752752/174098993-8a7495db-ec2f-4008-a3fc-f0e4ee3051d0.png">


<img width="264" alt="Снимок экрана 2022-06-16 в 17 58 16" src="https://user-images.githubusercontent.com/29752752/174099285-203029d7-c975-42b5-aea8-31cae5d2c9b3.png">

## Результаты
Для входных данных, взятых из книги, указанной выше, получаются следующие графики траекторий

![trajectoryGraphic](https://user-images.githubusercontent.com/29752752/174099681-23cf0617-07d6-415a-8dd8-ac910b192629.png)
![positionGraphic](https://user-images.githubusercontent.com/29752752/174099710-7d0313ef-4e4b-49b7-95bd-a940d00de993.png)
![velocityGraphic](https://user-images.githubusercontent.com/29752752/174099726-67f9f19d-ad73-4cc9-a593-71dd19b8d5b3.png)

## Как начать работу
Достаточно иметь на компьютере Java и SDK (к примеру corretto-11). Склонировать репозиторий к себе на устройство (с помощью IntelliJ IDEA). Указать путь сохранения графиков в константу ```PATH```, находящуюся в ```Main.kt```. Можно изменить входные данные по необходимости (переменная ```data```). Результатом работы программы будут файлы формата .png с изображением траекторий 
