![Linux](https://img.shields.io/badge/Linux-FCC624?style=for-the-badge&logo=linux&logoColor=black)
![Debian](https://img.shields.io/badge/Debian-D70A53?style=for-the-badge&logo=debian&logoColor=white)
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)
![Neovim](https://img.shields.io/badge/NeoVim-%2357A143.svg?&style=for-the-badge&logo=neovim&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![Nginx](https://img.shields.io/badge/nginx-%23009639.svg?style=for-the-badge&logo=nginx&logoColor=white)

![standards](assets/standards.png)

# OwlMap API
REST API backend for the OwlMap project.

### How this API is mapped

![entity_map](assets/entity_diagram.svg)

### Install and run this api

* clone this repository:

```bash
git clone https://github.com/inatagan/owlmapapi.git
```

* from the root dir navigate to the API dir with:

```bash
cd owlmap-java/
```

* run the API:

```bash
mvn spring-boot:run
```

### Endpoints provided

You can see full documentation and endpoints on the swagger page like this example:
```
http://localhost:8081/swagger-ui/index.html
```

```
/owlmap
```

```
/owlmap/users
```

```
/owlmap/markers
```

https://docs.google.com/presentation/d/1PXD4l1uJI6hr-5ITNHKOED0hNUztKRisUa3wb8BUS9U/edit?usp=sharing