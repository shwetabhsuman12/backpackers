FROM valian/docker-python-opencv-ffmpeg
USER root
RUN pip install flask &&\
    pip install requests &&\
    pip install -U flask-cors
WORKDIR /app
COPY main.py /app
RUN mkdir templates
RUN mkdir static
RUN mkdir static/img
COPY static/img/ibmnew.jpg static/img/
COPY static/img/comp.jpg static/img/
COPY templates/SignLanguage.html templates/
COPY templates/main.html templates/
COPY templates/Header.html templates/
COPY templates/Footer.html templates/
ENV FLASK_APP=main.py
