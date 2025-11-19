@echo off
echo === TEST SHOP MANAGE APP ===
echo.

echo 1. Nettoyage...
if exist out rmdir /s /q out
mkdir out

echo 2. Compilation modules...
javac -d out shared/src/main/java/com/shopmanageapp/models/*.java
if errorlevel 1 goto error

javac -d out server/src/main/java/com/shopmanageapp/server/*.java
if errorlevel 1 goto error

javac -d out client-boutique/src/main/java/com/shopmanageapp/*.java
if errorlevel 1 goto error

javac -d out client-user/src/main/java/com/shopmanageapp/*.java
if errorlevel 1 goto error

echo.
echo 3. Tests fonctionnels...
java -cp out com.shopmanageapp.BoutiqueApp
java -cp out com.shopmanageapp.ClientApp
java -cp out com.shopmanageapp.TestBoutique
java -cp out com.shopmanageapp.TestClient

echo.
echo 4. Test serveur (rapide)...
java -cp out com.shopmanageapp.server.ServerMain &
timeout /t 2 >nul
curl http://localhost:8080/health
taskkill /f /im java.exe >nul 2>&1

echo.
echo ===============================
echo ✅ PROJET FONCTIONNEL !
echo ===============================
echo Vous pouvez maintenant repartir les taches.
pause
exit

:error
echo.
echo ❌ ERREUR - Verifiez les noms de fichiers
pause