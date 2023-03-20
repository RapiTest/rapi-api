import subprocess
from subprocess import PIPE
from .config import Config


class RapiProc(object):

    def __init__(self, executable):
        self.path = executable
        
    def run(self, config: Config):
        proc = subprocess.Popen([self.path, "--call-by-api"],
                                stdin=PIPE, stderr=PIPE, stdout=PIPE, encoding="utf-8")
        (out, err) = proc.communicate(config.toStr())
        return {
            "out": out,
            "err": err,
            "status": proc.returncode
        }
