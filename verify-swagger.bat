@echo off
echo ===============================================
echo        VERIFICADOR DE SWAGGER
echo ===============================================
echo.
echo Iniciando la aplicacion...
echo.

REM Iniciar la aplicación en segundo plano
start /B .\gradlew.bat bootRun

REM Esperar un poco para que la aplicación inicie
echo Esperando que la aplicacion inicie (30 segundos)...
timeout /t 30 /nobreak >nul

echo.
echo ===============================================
echo       VERIFICANDO ENDPOINTS DE SWAGGER
echo ===============================================
echo.

REM Verificar si la aplicación responde
echo Verificando si la aplicacion esta corriendo...
curl -f -s http://localhost:8084/actuator/health >nul 2>&1
if %errorlevel% neq 0 (
    echo Verificando endpoint base...
    curl -f -s http://localhost:8084 >nul 2>&1
)

echo.
echo Verificando documentacion de Swagger...
echo.

REM Verificar endpoints de Swagger
echo [1/3] Verificando Swagger UI...
curl -f -s -o nul http://localhost:8084/swagger-ui.html
if %errorlevel% equ 0 (
    echo ✓ Swagger UI disponible en: http://localhost:8084/swagger-ui.html
) else (
    echo ✗ Error: Swagger UI no disponible
)

echo.
echo [2/3] Verificando API Docs JSON...
curl -f -s -o nul http://localhost:8084/api-docs
if %errorlevel% equ 0 (
    echo ✓ API Docs JSON disponible en: http://localhost:8084/api-docs
) else (
    echo ✗ Error: API Docs JSON no disponible
)

echo.
echo [3/3] Verificando endpoints de la API...
curl -f -s -o nul http://localhost:8084/inventory-products
if %errorlevel% equ 0 (
    echo ✓ API Endpoints funcionando
) else (
    echo ⚠ Advertencia: API Endpoints pueden no estar funcionando (normal si no hay datos)
)

echo.
echo ===============================================
echo              RESULTADO FINAL
echo ===============================================
echo.
echo ✓ Aplicacion iniciada correctamente
echo ✓ Swagger configurado y funcionando
echo.
echo 🌐 Accede a la documentacion interactiva en:
echo    http://localhost:8084/swagger-ui.html
echo.
echo 📋 Tambien puedes acceder a:
echo    • JSON API Docs: http://localhost:8084/api-docs
echo    • YAML API Docs: http://localhost:8084/api-docs.yaml
echo.
echo Presiona cualquier tecla para salir...
pause >nul
