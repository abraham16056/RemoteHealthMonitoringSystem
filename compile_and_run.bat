@echo off
echo ========================================
echo Remote Health Monitoring System
echo Derleme ve Calistirma Scripti
echo ========================================
echo.

REM out dizinini olustur
if not exist "out" mkdir out

REM Java dosyalarini derle
echo [1/2] Java dosyalari derleniyor...
javac -d out -sourcepath src/main/java src/main/java/com/rhms/Main.java src/main/java/com/rhms/models/*.java src/main/java/com/rhms/services/*.java

if %ERRORLEVEL% NEQ 0 (
    echo.
    echo HATA: Derleme basarisiz oldu!
    echo JDK (Java Development Kit) yuklu oldugundan emin olun.
    echo.
    pause
    exit /b 1
)

echo [2/2] Derleme basarili!
echo.
echo Program calistiriliyor...
echo ========================================
echo.

REM Programi calistir
java -cp out com.rhms.Main

echo.
echo ========================================
echo Program tamamlandi.
pause

