# TrajectoryInterpolation
## Описание
Студенческий проект, рещающий задачу интерполяции траектории с несколькими точками. Интерполяция траектории производилась по следующим формулам, которые описаны в книге Modern Robotics

<img width="279" alt="Снимок экрана 2022-06-16 в 17 57 06" src="https://user-images.githubusercontent.com/29752752/174098993-8a7495db-ec2f-4008-a3fc-f0e4ee3051d0.png">


<img width="264" alt="Снимок экрана 2022-06-16 в 17 58 16" src="https://user-images.githubusercontent.com/29752752/174099285-203029d7-c975-42b5-aea8-31cae5d2c9b3.png">

## Результаты
Для входных данных, взятых из книги, указанной выше, получаются следующие графики траекторий

![trajectoryGraphic](https://user-images.githubusercontent.com/29752752/174132166-a8a103ab-e538-44a3-ae1d-01183ff4ee0d.png)
![positionGraphic](https://user-images.githubusercontent.com/29752752/174132172-f083eaf2-4219-4116-a41d-f08e4246c589.png)
![velocityGraphic](https://user-images.githubusercontent.com/29752752/174132183-8b475f91-79b2-4406-81a3-06ba58e29a48.png)

## Как начать работу
Достаточно иметь на компьютере Java и SDK (к примеру corretto-11). Склонировать репозиторий к себе на устройство (с помощью IntelliJ IDEA). Указать путь сохранения графиков в константу ```PATH```, находящуюся в ```Main.kt```. Можно изменить входные данные по необходимости (переменная ```data```). Результатом работы программы будут файлы формата .png с изображением траекторий 
