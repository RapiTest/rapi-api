import childProcess from "child_process";

export class RapiProc {
  constructor(path) {
    this.execpath = path;
  }
  run(config) {
    const data = childProcess.spawnSync(this.execpath, ["--call-by-api"], {
      input: config.toString(),
      encoding: "utf-8",
    });
    return data;
  }
}
