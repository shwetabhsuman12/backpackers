FROM gcpprofileimg
USER root
WORKDIR /app
RUN pip install requests
RUN pip install flask
COPY setenv.sh /app
COPY propane-nomad-318909-3869de2a2cde.json /app
ENV GOOGLE_APPLICATION_CREDENTIALS=propane-nomad-318909-3869de2a2cde.json
COPY main.py /app/
ENV FLASK_APP=main.py
#RUN flask/bin/activate
