.PHONY=up build-tester
.EXPORT_ALL_VARIABLES:

SKAFFOLD?=skaffold
GOPRIVATE?=github.com/sbs-discovery-sweden/*
GO111MODULE?=on
CGO_ENABLED?=0
GOOS?=linux
GO_BIN?=app
GO?=go

up:
	$(MAKE) -C deployments/environment kafka
	$(SKAFFOLD) run

build-tester:
	$(MAKE) -C scripts/tester build
