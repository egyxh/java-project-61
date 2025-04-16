APP_NAME := app

.PHONY: build run-dist clean

build:
	@echo
	./gradlew installDist

run-dist: build
	@echo
	./build/install/$(APP_NAME)/bin/$(APP_NAME)

run:
	@echo
	./gradlew run

clean:
	@echo
	./gradlew clean
