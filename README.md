# Challenges and Limitations of This Repository

This repository was intended to provide a method for accessing weather data from the India Meteorological Department's website. However, due to several technical challenges encountered during development, I must advise against using this repository for any practical purposes:

- **SSL Certificate Issues**: Despite attempts to resolve SSL handshake exceptions by configuring a custom truststore, we encountered persistent errors related to certificate path validation (`javax.net.ssl.SSLHandshakeException: PKIX path building failed`). This suggests there might be issues with how the server's SSL certificates are configured or how they are being interpreted by Java.

- **Redirect Handling**: The server provided a redirect to an incorrect URL format (`https://city.imd.gov.incitywx/city_weather.php?id=43003`), which required manual correction in the code. This indicates potential server-side misconfigurations that could change at any time, breaking the tool.

- **Java Environment**: Various attempts to debug and configure SSL settings within different Java environments (including IntelliJ IDEA) have not resolved the core issues, suggesting that there might be underlying compatibility or configuration problems with Java's SSL/TLS implementations.

Given these unresolved issues, **I strongly recommend not using this repository** for any critical or production applications. The tool is currently non-functional due to these persistent problems.

---

_NOT AFFILIATED TO INDIA METEOROLOGICAL DEPARTMENT IN ANY WAY. ALL DUE CREDITS TO THEM, I'M ONLY PROVIDING A WAY TO ACCESS THE DATA. DATA IS PROVIDED AS IS WITHOUT ANY MODIFICATIONS. I scrape their website to get this data, and this tool may break as soon as they decide to change their website code. Therefore, please do not rely on this tool for critical applications._