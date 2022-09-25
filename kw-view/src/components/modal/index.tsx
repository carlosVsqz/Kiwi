import GUButton from '@components/control/gu-button';
import React, {useEffect} from 'react';
import Modal, {Props} from 'react-modal';
import jsx from "@i18n/properties";

interface AlertModalProps {
  height?: number | string;
  width?: number;
  onCancelClick?: () => void;
  onConfirmClick?: () => void;
}

const AlertModal = ({
  height = 'auto',
  width = 400,
  onCancelClick,
  onConfirmClick,
  ...props
}: AlertModalProps & Props) => {
  useEffect(() => {
    Modal.setAppElement('#modal');
  }, []);

  return (
    <Modal
      style={{
        overlay: {
          zIndex: 1000,
        },
        content: {
          border: 0,
          height: height,
          width: width,
          top: '50%',
          left: '50%',
          right: 'auto',
          bottom: 'auto',
          marginRight: '-50%',
          boxShadow: '0px 0px 16px 0px rgb(0 0 0 / 8%)',
          transform: 'translate(-50%, -50%)',
        },
      }}
      contentLabel="Modal"
      {...props}>
      <div className="alert-modal">
        <div className="alert-modal-header">
          <h3>{jsx.alert.h3}</h3>
          <p>{jsx.alert.p}</p>
        </div>
        <div className="alert-modal-footer">
          <GUButton shape="round" size="small" variant="contained" color="error" onClick={onCancelClick}>
            {jsx.alert.cancel}
          </GUButton>
          <GUButton shape="round" size="small" variant="contained" color="success" onClick={onConfirmClick}>
            {jsx.alert.ok}
          </GUButton>
        </div>
      </div>
    </Modal>
  );
};

export default AlertModal;
