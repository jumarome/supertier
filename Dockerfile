FROM airhacks/glassfish
COPY ./target/super-tier.war ${DEPLOYMENT_DIR}
