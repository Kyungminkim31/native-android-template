//
// Created by  kkim on 07/04/2020.
//
#include <jni.h>
#include <iostream>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_org_gaval_tutorial_MainActivity_getStringFromCpp(JNIEnv *env, jobject obj, jstring input) {

    std::string rtrVal = "How are you, ";
    const char *inCStr = env->GetStringUTFChars(input, NULL);

    if(NULL == inCStr) {
        return NULL;
    }

    rtrVal += inCStr;
    rtrVal += " ?";

    env->ReleaseStringUTFChars(input, inCStr);

    return env->NewStringUTF(rtrVal.c_str());
}