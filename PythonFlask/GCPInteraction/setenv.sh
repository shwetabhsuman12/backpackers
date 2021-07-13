#!/bin/sh
acctoken="gcloud auth application-default print-access-token"
export imgbytes=$(eval "$acctoken")
env
python3 main.py

