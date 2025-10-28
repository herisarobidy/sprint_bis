@echo off

:: Variables
set APP_NAME=FrameworkServlet
set SRC_DIR=src\main\java
set BUILD_DIR=build
set LIB_DIR=lib
set LOCAL_SERVLET_API_JAR=%LIB_DIR%\servlet-api.jar
set TEST_SERVLET_API_JAR=..\testFramework_S5\lib\servlet-api.jar

:: Choisir le JAR de l'API Servlet pour la compilation (Tomcat/Jakarta)
set "SERVLET_API_JAR="
if exist "%LOCAL_SERVLET_API_JAR%" (
    set "SERVLET_API_JAR=%LOCAL_SERVLET_API_JAR%"
)
if not defined SERVLET_API_JAR if exist "%TEST_SERVLET_API_JAR%" (
    set "SERVLET_API_JAR=%TEST_SERVLET_API_JAR%"
)
if not defined SERVLET_API_JAR (
    echo Erreur: servlet-api.jar introuvable ni dans "%LOCAL_SERVLET_API_JAR%" ni dans "%TEST_SERVLET_API_JAR%".
    echo Placez un JAR Jakarta Servlet ^(ex: servlet-api.jar^) dans l'un de ces emplacements et relancez.
    pause
    exit /b 1
)

:: Nettoyage
if exist "%BUILD_DIR%" (
    rmdir /s /q "%BUILD_DIR%"
)
mkdir "%BUILD_DIR%"

:: Compilation
echo Compilation de la librairie %APP_NAME%...
for /f "delims=" %%f in ('dir /b /s "%SRC_DIR%\*.java"') do (
    echo %%f>> sources.txt
)
javac -cp "%SERVLET_API_JAR%" -d "%BUILD_DIR%" @sources.txt
if errorlevel 1 (
    echo Erreur de compilation!
    del sources.txt
    pause
    exit /b 1
)
del sources.txt

:: Creation du JAR
echo Creation du JAR %APP_NAME%.jar...
pushd "%BUILD_DIR%"
jar -cvf %APP_NAME%.jar com
popd

:: Copie vers le projet de test
set TEST_LIB_DIR=..\testFramework_S5\lib
if not exist "%TEST_LIB_DIR%" (
    mkdir "%TEST_LIB_DIR%"
)
copy /Y "%BUILD_DIR%\%APP_NAME%.jar" "%TEST_LIB_DIR%\"

echo.
echo Librairie %APP_NAME% construite et copiee vers: %TEST_LIB_DIR%\%APP_NAME%.jar
echo.
pause
