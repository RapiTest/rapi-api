import pathlib
from setuptools import setup, find_packages

HERE = pathlib.Path(__file__).parent.resolve()

PACKAGE_NAME = "rapi_api"
AUTHOR = "Rapi Team"
AUTHOR_EMAIL = "rapitest.service@gmail.com"
URL = "https://github.com/RapiTest/rapi-api"

LICENSE = "MIT"
VERSION = "1.0.0"
DESCRIPTION = "Rapi API for Python provides user level api using rapi runner."
LONG_DESCRIPTION = (HERE / "README.md").read_text(encoding="utf8")
LONG_DESC_TYPE = "text/markdown"

CLASSIFIERS = [
    f"Programming Language :: Python :: 3.{str(v)}" for v in range(7, 12)]
print(CLASSIFIERS)
PYTHON_REQUIRES = ">=3.7"

setup(
    name=PACKAGE_NAME,
    version=VERSION,
    description=DESCRIPTION,
    long_description=LONG_DESCRIPTION,
    long_description_content_type=LONG_DESC_TYPE,
    author=AUTHOR,
    license=LICENSE,
    author_email=AUTHOR_EMAIL,
    url=URL,
    python_requires=PYTHON_REQUIRES,
    packages=find_packages(),
    classifiers=CLASSIFIERS,
)
